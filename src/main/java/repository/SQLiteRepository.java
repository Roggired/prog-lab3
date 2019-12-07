package repository;

import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;
import repository.annotations.Entity;
import repository.annotations.Id;
import repository.annotations.Stored;
import repository.exception.RepositoryException;
import story.environment.EnvironmentEntity;
import story.pokemon.PokemonEntity;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.*;

public final class SQLiteRepository<T> implements Repository<T>{
    private static final String DRIVER_CLASS_NAME = "org.sqlite.JDBC";
    private static final String URL_PROTOCOL = "jdbc:sqlite:";

    private static final String NOT_DTO_OBJECT_EXCEPTION = "Объект не аннотирован как DTO: ";
    private static final String NO_ID_MARKED_FIELD_EXCEPTION = "В объекте ни одно поле не помечено аннотацией Id: ";

    private static final Map<Class<?>, String> entityClassMap = new HashMap<Class<?>, String>() {{
        put(PokemonEntity.class, "Pokemons");
        put(EnvironmentEntity.class, "Environments");
    }};

    private static final Map<String, String> tablesMap = new HashMap<String, String>() {{
        put("Names", "Names");
        put("Activities", "Activities");
        put("Characteristics", "Characteristics");
        put("Features", "Features");
    }};

    private Connection connection;


    @AssistedInject
    public SQLiteRepository(@Assisted String pathToDB) throws RepositoryException {
        try {
            Class.forName(DRIVER_CLASS_NAME);
            connection = DriverManager.getConnection(URL_PROTOCOL + pathToDB);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RepositoryException(e);
        }
    }

    @Override
    public void save(T object) throws RepositoryException {
        templateProcessorMethod(object, statement -> {
            Integer id = getId(object);

            List<Field> storedFields = getStoredFields(object);
            List<String> tableKeys = getTableKeys(storedFields);

            for (int index = 0; index < storedFields.size(); index++) {
                Field storedField = storedFields.get(index);
                String tableKey = tableKeys.get(index);
                String tableName = tablesMap.get(tableKey);

                List<String> insertQueries = createInsertQueries(object,
                                                                 id,
                                                                 storedField,
                                                                 tableName);

                for (String insertQuery : insertQueries) {
                    statement.execute(insertQuery);
                }
            }
        });
    }

    @Override
    public T get(Class<T> clazz, Integer id) throws RepositoryException {
        try {
            T object = clazz.getConstructor().newInstance();

            templateProcessorMethod(object, statement -> {
                List<Field> storedFields = getStoredFields(object);
                List<String> tableKeys = getTableKeys(storedFields);

                for (int index = 0; index < tableKeys.size(); index++) {
                    Field storedField = storedFields.get(index);
                    String tableKey = tableKeys.get(index);
                    String tableName = tablesMap.get(tableKey);

                    String query = createSelectQuery(tableName, id);

                    ResultSet resultSet = statement.executeQuery(query);

                    writeResultInto(object, storedField, resultSet);
                }
            });

            return object;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RepositoryException(e);
        }
    }

    @Override
    public void modify(T object) throws RepositoryException {
        templateProcessorMethod(object, statement -> {
            delete(object);
            save(object);
        });
    }

    @Override
    public void delete(T object) throws RepositoryException {
        templateProcessorMethod(object, statement -> {
            Integer id = getId(object);

            List<Field> storedFields = getStoredFields(object);
            List<String> tableKeys = getTableKeys(storedFields);

            List<String> deleteQueries = createDeleteQueries(tableKeys, id);

            for (String deleteQuery : deleteQueries) {
                statement.execute(deleteQuery);
            }
        });
    }

    private void templateProcessorMethod(T object, Consumer<Statement> queryLogic) throws RepositoryException {
        checkThatObjectIsEntity(object);

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

    private void checkThatObjectIsEntity(T object) throws RepositoryException {
        if (object.getClass().getAnnotation(Entity.class) == null) {
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

    private List<String> getTableKeys(List<Field> storedFields) {
        List<String> tableKeys = new ArrayList<>();

        storedFields.forEach(storedField -> {
            tableKeys.add(storedField.getAnnotation(Stored.class).TableKey());
        });

        return tableKeys;
    }

    private String createSelectQuery(String tableName,
                                     Integer id) {
        return "SELECT * FROM '" + tableName + "' WHERE id=" + id;
    }

    private List<String> createInsertQueries(T object,
                                             Integer id,
                                             Field storedField,
                                             String tableName) throws IllegalAccessException {
        List<String> insertQueries = new ArrayList<>();

        String generalString = "INSERT INTO '" + tableName + "' VALUES(" + id + ",";

        StringBuilder query = new StringBuilder(generalString);

        if (storedField.getType().equals(List.class)) {
            List list = (List)storedField.get(object);

            for (Object member : list) {
                query.append("'");
                query.append(member);
                query.append("')");

                insertQueries.add(query.toString());

                query = new StringBuilder(generalString);
            }

            return insertQueries;
        }

        query.append("'");
        query.append(storedField.get(object));
        query.append("')");

        insertQueries.add(query.toString());

        return insertQueries;
    }

    private List<String> createDeleteQueries(List<String> tableKeys,
                                             Integer id) {
        List<String> deleteQueries = new ArrayList<>();

        for (int index = 0; index < tableKeys.size(); index++) {
            String tableName = tablesMap.get(tableKeys.get(index));
            String query = "DELETE FROM '" + tableName + "' WHERE id=" + id;

            deleteQueries.add(query);
        }

        return deleteQueries;
    }
    private void writeResultInto(T object,
                                 Field storedField,
                                 ResultSet resultSet) throws SQLException, IllegalAccessException {
        if (storedField.getType().equals(List.class)) {
            List list = new ArrayList();

            while(resultSet.next()) {
                list.add(resultSet.getObject(2));
            }

            storedField.set(object, list);

            return;
        }

        storedField.set(object, resultSet.getObject(2));
    }

    @FunctionalInterface
    public interface Consumer<E> {
        void accept(E e) throws SQLException, IllegalAccessException, RepositoryException;
    }
}
