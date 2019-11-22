package story.teller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Injector;
import jsonreader.JSONReader;
import story.activity.exception.ActivityException;
import story.activity.factory.IActivityFactory;
import story.characteristic.Characteristic;
import story.environment.DTOEnvironment;
import story.environment.Environment;
import story.environment.factory.IEnvironmentFactory;
import story.pokemon.DTOPokemon;
import story.pokemon.Pokemon;
import story.pokemon.factory.IPokemonFactory;

import java.util.ArrayList;
import java.util.List;

public abstract class StoryTeller {
    private final String pokemonJsonDirectory = "jsons/pokemons/";
    private final String environmentJsonDirectory = "jsons/environments/";


    public abstract String tellStory(Injector injector, ObjectMapper objectMapper) throws ActivityException;

    protected Pokemon createPokemonFromJSON(String fileName,
                                            ObjectMapper objectMapper,
                                            Injector injector) {
        JSONReader<DTOPokemon> jsonReader = new JSONReader<>(objectMapper);
        DTOPokemon dtoPokemon = jsonReader.read(pokemonJsonDirectory + fileName,
                                                DTOPokemon.class);

        IActivityFactory activityFactory = injector.getInstance(IActivityFactory.class);
        IPokemonFactory pokemonFactory = injector.getInstance(IPokemonFactory.class);

        List<Characteristic> characteristics = new ArrayList<>();
        dtoPokemon.characteristicsStrings.forEach(string -> characteristics.add(new Characteristic(string)));

        return pokemonFactory.create(dtoPokemon.name,
                                     characteristics,
                                     activityFactory.create(dtoPokemon.activitiesNames),
                                     dtoPokemon.features);
    }

    protected Environment createEnvironmentFromJSON(String fileName,
                                                    ObjectMapper objectMapper,
                                                    Injector injector) {
        JSONReader<DTOEnvironment> jsonReader = new JSONReader<>(objectMapper);
        DTOEnvironment dtoEnvironment = jsonReader.read(environmentJsonDirectory + fileName, DTOEnvironment.class);

        IEnvironmentFactory environmentFactory = injector.getInstance(IEnvironmentFactory.class);

        return environmentFactory.create(dtoEnvironment.name, dtoEnvironment.features);
    }
}
