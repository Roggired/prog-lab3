package app.injector;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import repository.Repository;
import repository.SQLiteRepository;
import repository.configuration.ConfigurationReader;
import repository.configuration.JSONDBConfigurationReader;
import repository.configuration.factory.ConfigurationReaderFactory;
import repository.factory.RepositoryFactory;
import story.creator.Creator;
import story.creator.GuiceCreator;
import story.creator.factory.CreatorFactory;
import story.environment.EnvironmentEntity;
import story.pokemon.PokemonEntity;
import story.teller.Lab4StoryTeller;
import story.teller.StoryTeller;
import story.teller.factory.StoryTellerFactory;

public class Lab4Module extends AbstractModule {

    @Override
    protected void configure() {
        install(new FactoryModuleBuilder()
                .implement(StoryTeller.class, Lab4StoryTeller.class)
                .build(StoryTellerFactory.class));
        install(new FactoryModuleBuilder()
                .implement(ConfigurationReader.class, JSONDBConfigurationReader.class)
                .build(ConfigurationReaderFactory.class));
        install(new FactoryModuleBuilder()
                .implement(new TypeLiteral<Repository<PokemonEntity>>(){}, new TypeLiteral<SQLiteRepository<PokemonEntity>>(){})
                .build(new TypeLiteral<RepositoryFactory<PokemonEntity>>(){}));
        install(new FactoryModuleBuilder()
                .implement(new TypeLiteral<Repository<EnvironmentEntity>>(){}, new TypeLiteral<SQLiteRepository<EnvironmentEntity>>(){})
                .build(new TypeLiteral<RepositoryFactory<EnvironmentEntity>>(){}));
        install(new FactoryModuleBuilder()
                .implement(Creator.class, GuiceCreator.class)
                .build(CreatorFactory.class));
    }
}
