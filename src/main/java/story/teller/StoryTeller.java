package story.teller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Injector;
import story.activity.exception.ActivityException;
import story.environment.Environment;
import story.pokemon.Pokemon;

public abstract class StoryTeller {
    private final String pokemonJsonDirectory = "jsons/pokemons/";
    private final String environmentJsonDirectory = "jsons/environments/";


    public abstract String tellStory(Injector injector, ObjectMapper objectMapper) throws ActivityException;

    protected Pokemon createPokemonFromJSON(String fileName,
                                            ObjectMapper objectMapper,
                                            Injector injector) {
        /*JSONReader<PokemonEntity> jsonReader = new JSONReader<>(objectMapper);
        PokemonEntity pokemonEntity = jsonReader.read(pokemonJsonDirectory + fileName,
                                                PokemonEntity.class);

        IActivityFactory activityFactory = injector.getInstance(IActivityFactory.class);
        IPokemonFactory pokemonFactory = injector.getInstance(IPokemonFactory.class);

        List<Characteristic> characteristics = new ArrayList<>();
        pokemonEntity.characteristicsStrings.forEach(string -> characteristics.add(new Characteristic(string)));

        return pokemonFactory.create(pokemonEntity.name,
                                     characteristics,
                                     activityFactory.create(pokemonEntity.activitiesNames),
                                     pokemonEntity.features);*/
        return null;
    }

    protected Environment createEnvironmentFromJSON(String fileName,
                                                    ObjectMapper objectMapper,
                                                    Injector injector) {
        /*JSONReader<EnvironmentEntity> jsonReader = new JSONReader<>(objectMapper);
        EnvironmentEntity environmentEntity = jsonReader.read(environmentJsonDirectory + fileName, EnvironmentEntity.class);

        IEnvironmentFactory environmentFactory = injector.getInstance(IEnvironmentFactory.class);

        return environmentFactory.create(environmentEntity.name, environmentEntity.features);*/

        return null;
    }
}
