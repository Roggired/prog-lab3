package app.injector;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import story.activity.factory.IActivityFactory;
import story.activity.factory.JSONActivityFactory;
import story.environment.Environment;
import story.environment.factory.IEnvironmentFactory;
import story.pokemon.Pokemon;
import story.pokemon.factory.IPokemonFactory;
import story.teller.Lab4StoryTeller;
import story.teller.StoryTeller;

public class Lab4Module extends AbstractModule {

    @Override
    protected void configure() {
        install(new FactoryModuleBuilder()
                .implement(Environment.class, Environment.class)
                .build(IEnvironmentFactory.class));
        install(new FactoryModuleBuilder()
                .implement(Pokemon.class, Pokemon.class)
                .build(IPokemonFactory.class));
        bind(IActivityFactory.class).to(JSONActivityFactory.class);
        bind(StoryTeller.class).to(Lab4StoryTeller.class);
    }
}
