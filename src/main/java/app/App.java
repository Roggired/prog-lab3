package app;

import app.injector.Lab3Module;
import app.injector.Lab4Module;
import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.google.inject.internal.asm.$ClassTooLargeException;
import repository.Repository;
import repository.SQLiteRepository;
import story.environment.DTOEnvironment;
import story.pokemon.DTOPokemon;
import story.pokemon.Pokemon;
import story.teller.StoryTeller;
import story.activity.exception.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class App {
    public static void main(String[] args) throws Exception, ActivityException {
        /*ObjectMapper objectMapper = new ObjectMapper();

        Injector injector = Guice.createInjector(new Lab4Module());

        StoryTeller storyTeller = injector.getInstance(StoryTeller.class);
        String story = storyTeller.tellStory(injector, objectMapper);

        System.out.println(story);*/

        Class.forName("org.sqlite.JDBC");
        /*Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/db_sqlite/Test.s3db");
        Statement statement = connection.createStatement();
        statement.execute("INSERT INTO 'Pokemons' VALUES ('3', 'оскар')");

        ResultSet resultSet = statement.executeQuery("SELECT * FROM 'Pokemons'");

        StringBuilder stringBuilder = new StringBuilder();
        while(resultSet.next()) {
            stringBuilder.append(resultSet.getInt("id") + " ");
            stringBuilder.append(resultSet.getString("name") + " ");
        }

        System.out.println(stringBuilder.toString());*/


        Repository<DTOPokemon> repository = new SQLiteRepository<>("src/main/resources/db_sqlite/Test.s3db",
                                                              "Pokemons");

        DTOPokemon dtoPokemon = new DTOPokemon();
        dtoPokemon.id = 1;
        dtoPokemon.name = "fille";
        repository.save(dtoPokemon);

        System.out.println("Pokemon was saved: " + dtoPokemon.name);

        dtoPokemon = repository.get(dtoPokemon);

        System.out.println("Pokemon name is: " + dtoPokemon.name);

        dtoPokemon.name = "fille new";
        repository.modify(dtoPokemon);

        dtoPokemon = repository.get(dtoPokemon);

        System.out.println("Pokemon new name is: " + dtoPokemon.name);

        repository.delete(dtoPokemon);

        System.out.println("Pokemon was deleted: " + dtoPokemon.name);


        Repository<DTOEnvironment> repositoryEnvironment = new SQLiteRepository<>("src/main/resources/db_sqlite/Test.s3db",
                                                                             "Environments");

        DTOEnvironment dtoEnvironment = new DTOEnvironment();
        dtoEnvironment.id = 1;
        dtoEnvironment.name = "hall";
        repositoryEnvironment.save(dtoEnvironment);

        System.out.println("Environment was saved: " + dtoEnvironment.name);

        dtoEnvironment = repositoryEnvironment.get(dtoEnvironment);

        System.out.println("Environment name is: " + dtoEnvironment.name);

        dtoEnvironment.name = "hall new";
        repositoryEnvironment.modify(dtoEnvironment);

        dtoEnvironment = repositoryEnvironment.get(dtoEnvironment);

        System.out.println("Environment new name is: " + dtoEnvironment.name);

        repositoryEnvironment.delete(dtoEnvironment);

        System.out.println("Environment was deleted: " + dtoEnvironment.name);
    }
}
