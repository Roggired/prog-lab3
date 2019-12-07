package story.creator;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import repository.Repository;
import story.activity.factory.IActivityFactory;
import story.activity.factory.ActivityFactory;
import story.characteristic.Characteristic;
import story.environment.Environment;
import story.environment.EnvironmentEntity;
import story.environment.factory.EnvironmentFactory;
import story.environment.feature.Feature;
import story.pokemon.Pokemon;
import story.pokemon.PokemonEntity;
import story.pokemon.factory.PokemonFactory;

import java.util.ArrayList;
import java.util.List;

public final class GuiceCreator implements Creator {
    private Repository<PokemonEntity> pokemonEntityRepository;
    private Repository<EnvironmentEntity> environmentEntityRepository;
    private Injector injector;


    @AssistedInject
    public GuiceCreator(@Assisted Repository<PokemonEntity> pokemonEntityRepository,
                        @Assisted Repository<EnvironmentEntity> environmentEntityRepository) {
        this.pokemonEntityRepository = pokemonEntityRepository;
        this.environmentEntityRepository = environmentEntityRepository;
        this.injector = Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {
                install(new FactoryModuleBuilder()
                        .implement(Environment.class, Environment.class)
                        .build(EnvironmentFactory.class));
                install(new FactoryModuleBuilder()
                        .implement(Pokemon.class, Pokemon.class)
                        .build(PokemonFactory.class));
                bind(IActivityFactory.class).to(ActivityFactory.class);
            }
        });
    }

    @Override
    public Pokemon createPokemon(Integer id) {
        PokemonEntity pokemonEntity = pokemonEntityRepository.get(PokemonEntity.class, id);

        IActivityFactory activityFactory = injector.getInstance(IActivityFactory.class);
        PokemonFactory pokemonFactory = injector.getInstance(PokemonFactory.class);

        List<Characteristic> characteristics = new ArrayList<>();
        pokemonEntity.characteristicsStrings.forEach(string -> characteristics.add(new Characteristic(string)));

        List<Feature> features = new ArrayList<>();
        pokemonEntity.featuresStrings.forEach(featureString -> features.add(new Feature(featureString)));

        return pokemonFactory.create(pokemonEntity.name,
                characteristics,
                activityFactory.create(pokemonEntity.activitiesNames),
                features);
    }

    @Override
    public Environment createEnvironment(Integer id) {
        EnvironmentEntity environmentEntity = environmentEntityRepository.get(EnvironmentEntity.class, id);

        EnvironmentFactory environmentFactory = injector.getInstance(EnvironmentFactory.class);

        List<Feature> features = new ArrayList<>();
        environmentEntity.featuresStrings.forEach(featureString -> features.add(new Feature(featureString)));

        List<Characteristic> characteristics = new ArrayList<>();
        environmentEntity.characteristicsStrings.forEach(characteristicString -> characteristics.add(new Characteristic(characteristicString)));

        return environmentFactory.create(environmentEntity.name, characteristics, features);
    }
}
