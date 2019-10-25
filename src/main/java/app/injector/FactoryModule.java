package app.injector;

import activity.factory.IActivityFactory;
import activity.factory.JSONActivityFactory;
import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import environment.Environment;
import environment.factory.IEnvironmentFactory;
import pokemon.factory.IPokemonFactory;
import pokemon.Pokemon;

public class FactoryModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new FactoryModuleBuilder()
                .implement(Environment.class, Environment.class)
                .build(IEnvironmentFactory.class));
        install(new FactoryModuleBuilder()
                .implement(Pokemon.class, Pokemon.class)
                .build(IPokemonFactory.class));
        bind(IActivityFactory.class).to(JSONActivityFactory.class);
    }
}
