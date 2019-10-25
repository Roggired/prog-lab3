package app.injector;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import environment.Environment;
import environment.IEnvironmentFactory;
import pokemon.IPokemonFactory;
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
    }
}
