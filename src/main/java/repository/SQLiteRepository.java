package repository;

import repository.annotations.DTO;
import repository.annotations.Id;
import repository.annotations.Stored;
import repository.exception.RepositoryException;

import java.lang.reflect.Field;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public final class SQLiteRepository<T> extends Repository<T>{
    private static final String DRIVER_CLASS_NAME = "org.sqlite.JDBC";
    private static final String URL_PROTOCOL = "jdbc:sqlite:";

    private static final String NOT_DTO_OBJECT_EXCEPTION = "Объект не аннотирован как DTO: ";
    private static final String NO_ID_MARKED_FIELD_EXCEPTION = "В объекте ни одно поле не помечено аннотацией Id: ";

    private String tableName;


    public SQLiteRepository(String path,
                            String tableName) throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER_CLASS_NAME);
        connection = DriverManager.getConnection(URL_PROTOCOL + path);

        useTable(tableName);
    }

    public void useTable(String tableName) {
        this.tableName = tableName;
    }

    @Override
    public void save(T object) throws RepositoryException {
        templateProcessorMethod(object, statement -> {
            List<Field> storedFields = getStoredFields(object);

            String query = "INSERT INTO '" + tableName + "' VALUES(";

            query = appendStoredValues(query, storedFields, object);

            statement.execute(query);
        });
    }

    @Override
    public T get(T object) throws RepositoryException {
        templateProcessorMethod(object, statement -> {
            Integer id = getId(object);

            String query = "SELECT * FROM '" + tableName + "' WHERE id = " + id;

            ResultSet resultSet = statement.executeQuery(query);

            writeResultInto(object, resultSet);
        });

        return object;
    }

    @Override
    public void modify(T object) throws RepositoryException {
        templateProcessorMethod(object, statement -> {
            Integer id = getId(object);

            List<Field> storedFields = getStoredFields(object);

            String query = "UPDATE '" + tableName + "' SET ";

            query = appendKeyToValueStoredPairs(object,
                                                query,
                                                storedFields);
            query += " WHERE id=" + id;

            statement.execute(query);
        });
    }

    @Override
    public void delete(T object) throws RepositoryException {
        templateProcessorMethod(object, statement -> {
            Integer id = getId(object);

            String query = "DELETE FROM '" + tableName + "' WHERE id = " + id;

            statement.execute(query);
        });
    }

    private void templateProcessorMethod(T object, Consumer<Statement> queryLogic) throws RepositoryException {
        checkThatObjectIsDTO(object);

        try(Statement statement = connection.createStatement()) {
            queryLogic.accept(statement);
        } catch (SQLException | IllegalAccessException e) {
            throw new RepositoryException(e);
        }
    }

    @Override
    public Iterator<T> getAll() {
        return null;
    }

    private void checkThatObjectIsDTO(T object) throws RepositoryException {
        if (object.getClass().getAnnotation(DTO.class) == null) {
            throw new RepositoryException(NOT_DTO_OBJECT_EXCEPTION + object.getClass().getName());
        }
    }

    private List<Field> getStoredFields(T object) {
        Field[] fieldsArray = object.getClass().getDeclaredFields();
        List<Field> fields = Arrays.asList(fieldsArray);

        List<Field> storedFields = new ArrayList<>();

        fields.forEach(field -> {
            if (field.getAnnotation(Stored.class) != null) {
                storedFields.add(field);
            }
        });

        return storedFields;
    }

    private Field getIdField(T object) throws RepositoryException {
        Field[] fields = object.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.getAnnotation(Id.class) != null) {
                return field;
            }
        }

        throw new RepositoryException(NO_ID_MARKED_FIELD_EXCEPTION + object.getClass().getName());
    }

    private Integer getId(T object) throws IllegalAccessException, RepositoryException {
        return (Integer) getIdField(object).get(object);
    }

    private String appendStoredValues(String query,
                                      List<Field> storedFields,
                                      T object) throws IllegalAccessException {
        StringBuilder stringBuilder = new StringBuilder(query);

        for (Field storedField : storedFields) {
            stringBuilder.append("'");
            stringBuilder.append(storedField.get(object));
            stringBuilder.append("'");

            if (storedFields.indexOf(storedField) != storedFields.size() - 1) {
                stringBuilder.append(", ");
            }
        }
        storedFields.forEach(storedField -> {

        });
        stringBuilder.append(")");

        return stringBuilder.toString();
    }

    private String appendKeyToValueStoredPairs(T object,
                                               String query,
                                               List<Field> storedFields) throws IllegalAccessException {
        StringBuilder queryBuilder = new StringBuilder(query);
        for (Field storedField : storedFields) {
            String fieldName = storedField.getName();
            Object fieldValue = storedField.get(object);

            queryBuilder.append(fieldName);
            queryBuilder.append("=");

            if (storedField.getType().equals(String.class)) {
                queryBuilder.append("'" + fieldValue + "'");
            } else {
                queryBuilder.append("" + fieldValue + "");
            }

            if (storedFields.indexOf(storedField) != storedFields.size() - 1) {
                queryBuilder.append(", ");
            }
        }
        return queryBuilder.toString();
    }

    private void writeResultInto(T object, ResultSet resultSet) throws SQLException, IllegalAccessException {
        List<Field> storedFields = getStoredFields(object);

        int index = 1;
        do {
            Object entity = resultSet.getObject(index);
            storedFields.get(index - 1).set(object, entity);

            index++;
        } while (resultSet.next());
    }


    @FunctionalInterface
    public interface Consumer<E> {
        void accept(E e) throws SQLException, IllegalAccessException, RepositoryException;
    }
}
