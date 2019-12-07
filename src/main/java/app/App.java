package app;

import app.injector.Lab4Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.*;
import jsonreader.JSONReader;
import repository.Repository;
import repository.SQLiteRepository;
import repository.configuration.ConfigurationReader;
import repository.configuration.factory.ConfigurationReaderFactory;
import repository.factory.RepositoryFactory;
import story.activity.exception.*;
import story.creator.Creator;
import story.creator.factory.CreatorFactory;
import story.environment.EnvironmentEntity;
import story.pokemon.PokemonEntity;
import story.teller.StoryTeller;
import story.teller.factory.StoryTellerFactory;

import java.util.ArrayList;


public class App {
    public static void main(String[] args) throws ActivityException {
        ObjectMapper objectMapper = new ObjectMapper();

        Injector injector = Guice.createInjector(new Lab4Module());

        RepositoryFactory<PokemonEntity> pokemonEntityRepositoryFactory = injector.getInstance(Key.get(new TypeLiteral<RepositoryFactory<PokemonEntity>>() {}));
        Repository<PokemonEntity> pokemonEntityRepository = pokemonEntityRepositoryFactory.create("src/main/resources/db_sqlite/Test.s3db");

        RepositoryFactory<EnvironmentEntity> environmentEntityRepositoryFactory = injector.getInstance(Key.get(new TypeLiteral<RepositoryFactory<EnvironmentEntity>>(){}));
        Repository<EnvironmentEntity> environmentEntityRepository = environmentEntityRepositoryFactory.create("src/main/resources/db_sqlite/Test.s3db");

        CreatorFactory creatorFactory = injector.getInstance(CreatorFactory.class);
        Creator creator = creatorFactory.create(pokemonEntityRepository, environmentEntityRepository);

        ConfigurationReaderFactory configurationReaderFactory = injector.getInstance(ConfigurationReaderFactory.class);
        ConfigurationReader configurationReader = configurationReaderFactory.create("jsons/idMap.json", new JSONReader<>(objectMapper));

        StoryTellerFactory storyTellerFactory = injector.getInstance(StoryTellerFactory.class);
        StoryTeller storyTeller = storyTellerFactory.create(configurationReader, creator);

        String story = storyTeller.tellStory(injector, objectMapper);

        System.out.println(story);


        /*Repository<PokemonEntity> repository = new SQLiteRepository<>("src/main/resources/db_sqlite/Test.s3db");

        PokemonEntity pokemonEntity = new PokemonEntity();
        pokemonEntity.id = 1;
        pokemonEntity.name = "fille";
        repository.save(pokemonEntity);

        System.out.println("Pokemon was saved: " + pokemonEntity.name);

        pokemonEntity = repository.get(PokemonEntity.class, pokemonEntity.id);

        System.out.println("Pokemon name is: " + pokemonEntity.name);

        pokemonEntity.name = "fille new";
        repository.modify(pokemonEntity);

        pokemonEntity = repository.get(PokemonEntity.class, pokemonEntity.id);

        System.out.println("Pokemon new name is: " + pokemonEntity.name);

        repository.delete(pokemonEntity);

        System.out.println("Pokemon was deleted: " + pokemonEntity.name);


        Repository<EnvironmentEntity> repositoryEnvironment = new SQLiteRepository<>("src/main/resources/db_sqlite/Test.s3db");

        EnvironmentEntity environmentEntity = new EnvironmentEntity();
        environmentEntity.id = 1;
        environmentEntity.name = "hall";
        repositoryEnvironment.save(environmentEntity);

        System.out.println("Environment was saved: " + environmentEntity.name);

        environmentEntity = repositoryEnvironment.get(EnvironmentEntity.class, environmentEntity.id);

        System.out.println("Environment name is: " + environmentEntity.name);

        environmentEntity.name = "hall new";
        repositoryEnvironment.modify(environmentEntity);

        environmentEntity = repositoryEnvironment.get(EnvironmentEntity.class, environmentEntity.id);

        System.out.println("Environment new name is: " + environmentEntity.name);

        repositoryEnvironment.delete(environmentEntity);

        System.out.println("Environment was deleted: " + environmentEntity.name);*/

        /*Repository<PokemonEntity> pokemonEntityRepository1 = new SQLiteRepository<>("src/main/resources/db_sqlite/Test.s3db");
        PokemonEntity pokemonEntity = new PokemonEntity();
        pokemonEntity.id = 7;
        pokemonEntity.name = "";
        pokemonEntity.activitiesNames = new ArrayList<String>() {{
            add("BecomeClear");
            add("Think");
            add("ThinkHowNeed");
        }};
        pokemonEntity.featuresStrings = new ArrayList<String>() {{
        }};
        pokemonEntity.characteristicsStrings = new ArrayList<String>() {{
        }};

        pokemonEntityRepository.modify(pokemonEntity);*/
        /*Repository<EnvironmentEntity> environmentEntityRepository = new SQLiteRepository<>("src/main/resources/db_sqlite/Test.s3db");
        EnvironmentEntity environmentEntity = new EnvironmentEntity();
        environmentEntity.id = 20;
        environmentEntity.name = "часы";
        environmentEntity.featuresStrings = new ArrayList<String>() {{
            add("это можно прикрепить");
        }};

        environmentEntityRepository.save(environmentEntity);*/
        /*PokemonEntity inDB = pokemonEntityRepository.get(PokemonEntity.class, 1);
        System.out.println(inDB.name);

        pokemonEntity.activitiesNames.add("activity5");

        pokemonEntityRepository.modify(pokemonEntity);

        inDB = pokemonEntityRepository.get(PokemonEntity.class, 10);

        System.out.println(inDB.activitiesNames);

        pokemonEntityRepository.delete(pokemonEntity);*/
    }
}
