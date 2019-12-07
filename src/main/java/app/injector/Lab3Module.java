package app.injector;

import story.activity.factory.IActivityFactory;
import story.activity.factory.ActivityFactory;
import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import story.environment.Environment;
import story.environment.factory.EnvironmentFactory;
import story.pokemon.factory.PokemonFactory;
import story.pokemon.Pokemon;
import story.teller.Lab3StoryTeller;
import story.teller.StoryTeller;

public class Lab3Module extends AbstractModule {

    @Override
    protected void configure() {
        install(new FactoryModuleBuilder()
                .implement(Environment.class, Environment.class)
                .build(EnvironmentFactory.class));
        install(new FactoryModuleBuilder()
                .implement(Pokemon.class, Pokemon.class)
                .build(PokemonFactory.class));
        bind(IActivityFactory.class).to(ActivityFactory.class);
        bind(StoryTeller.class).to(Lab3StoryTeller.class);
    }
}
