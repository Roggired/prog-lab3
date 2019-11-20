package app.injector;

import story.activity.factory.IActivityFactory;
import story.activity.factory.JSONActivityFactory;
import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import story.environment.Environment;
import story.environment.factory.IEnvironmentFactory;
import story.pokemon.factory.IPokemonFactory;
import story.pokemon.Pokemon;
import story.teller.Lab3StoryTeller;
import story.teller.StoryTeller;

public class Lab3Module extends AbstractModule {

    @Override
    protected void configure() {
        install(new FactoryModuleBuilder()
                .implement(Environment.class, Environment.class)
                .build(IEnvironmentFactory.class));
        install(new FactoryModuleBuilder()
                .implement(Pokemon.class, Pokemon.class)
                .build(IPokemonFactory.class));
        bind(IActivityFactory.class).to(JSONActivityFactory.class);
        bind(StoryTeller.class).to(Lab3StoryTeller.class);
    }
}
