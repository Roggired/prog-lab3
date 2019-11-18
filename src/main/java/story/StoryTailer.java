package story;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Injector;
import story.activity.*;
import story.activity.exception.ActivityException;
import story.activity.factory.IActivityFactory;
import story.characteristic.Characteristic;
import story.characteristic.reason.IReasonProducer;
import story.characteristic.reason.Reason;
import story.characteristic.reason.ReasonBasedOnActivity;
import story.environment.Environment;
import story.pokemon.DTOPokemon;
import story.pokemon.Pokemon;
import story.pokemon.factory.IPokemonFactory;

import java.util.ArrayList;
import java.util.List;

public class StoryTailer {
    private Injector injector;
    private ObjectMapper objectMapper;
    private StoryTailerConfiguration storyTailerConfiguration;


    public StoryTailer(Injector injector,
                       ObjectMapper objectMapper,
                       StoryTailerConfiguration storyTailerConfiguration) {
        this.injector = injector;
        this.objectMapper = objectMapper;
        this.storyTailerConfiguration = storyTailerConfiguration;
    }


    public String tellStory() throws ActivityException {
        Pokemon fille = createPokemonFromJSON(storyTailerConfiguration.filleJsonFileName,
                                              objectMapper,
                                              injector);
        Pokemon rulle = createPokemonFromJSON(storyTailerConfiguration.rulleJsonFileName,
                                              objectMapper,
                                              injector);
        Pokemon oskar = createPokemonFromJSON(storyTailerConfiguration.oskarJsonFileName,
                                              objectMapper,
                                              injector);
        Pokemon karlson = createPokemonFromJSON(storyTailerConfiguration.karlsonJsonFileName,
                                                objectMapper,
                                                injector);

        Environment hall = createEnvironmentFromJSON(storyTailerConfiguration.hallJsonFileName,
                                                     objectMapper);
        Environment underWindow = createEnvironmentFromJSON(storyTailerConfiguration.underWindowJsonFileName,
                                                            objectMapper);
        Environment wallet = createEnvironmentFromJSON(storyTailerConfiguration.walletJsonFileName,
                                                       objectMapper);
        Environment soupBowl = createEnvironmentFromJSON(storyTailerConfiguration.soupBownJsonFileName,
                                                         objectMapper);
        Environment soup = createEnvironmentFromJSON(storyTailerConfiguration.soupJsonFileName,
                                                     objectMapper);
        Environment watches = createEnvironmentFromJSON(storyTailerConfiguration.watchesJsonFileName,
                                                        objectMapper);
        Environment lamp = createEnvironmentFromJSON(storyTailerConfiguration.lampJsonFileName,
                                                     objectMapper);

        StringBuilder result = new StringBuilder();
        result.append(fille.doActivity(GoIn.NAME, hall))
                .append(System.lineSeparator());
        result.append(rulle.doActivity(GoIn.NAME, hall))
                .append(System.lineSeparator());
        result.append(oskar.doActivity(StayAlong.NAME))
                .append(System.lineSeparator());
        result.append(oskar.doActivity(Bore.NAME))
                .append(System.lineSeparator());
        result.append(oskar.doActivityBecause("Чтобы посмотреть, что делают его новые друзья",
                                              GoIn.NAME,
                                              hall))
                .append(System.lineSeparator());
        result.append(karlson.doActivity(GoOver.NAME, underWindow))
                .append(System.lineSeparator());
        result.append(karlson.doActivity(PutIn.NAME, wallet, soupBowl))
                .append(System.lineSeparator());

        fille.doActivity(Eat.NAME, soup);
        rulle.doActivity(Eat.NAME, soup);
        oskar.doActivity(Eat.NAME, soup);

        List<IReasonProducer> reasonProducers = new ArrayList<>();
        reasonProducers.add(fille);
        reasonProducers.add(rulle);
        reasonProducers.add(oskar);

        List<String> activityNames = new ArrayList<>();
        activityNames.add(Eat.NAME);
        Reason reason = new ReasonBasedOnActivity(reasonProducers, activityNames);
        Characteristic characteristic = new Characteristic("сухой", reason);
        wallet.addCharacteristic(characteristic);

        result.append(wallet.getNameWithCharacteristics())
                .append(System.lineSeparator());
        result.append(karlson.doActivity(AttachTo.NAME, watches, lamp))
                .append(System.lineSeparator());

        watches.addCharacteristic(new Characteristic("висели на виду, слегка раскачиваясь", null));

        result.append(watches.getNameWithCharacteristics())
                .append(System.lineSeparator());
        result.append(fille.doActivityBecause("Когда вернулся в комнату",
                                             See.NAME,
                                             watches))
                .append(System.lineSeparator());
        result.append(rulle.doActivityBecause("Когда вернулся в комнату",
                                              See.NAME,
                                              watches))
                .append(System.lineSeparator());
        result.append(oskar.doActivityBecause("Когда вернулся в комнату",
                                              See.NAME,
                                              watches))
                .append(System.lineSeparator());

        result.append(System.lineSeparator());
        result.append(System.lineSeparator());

        return result.toString();
    }
    private Pokemon createPokemonFromJSON(String fileName,
                                          ObjectMapper objectMapper,
                                          Injector injector) {
        JSONReader<DTOPokemon> jsonReader = new JSONReader<>(objectMapper);
        DTOPokemon dtoPokemon = jsonReader.read(storyTailerConfiguration.pokemonJsonDirectory + fileName,
                                                DTOPokemon.class);

        IActivityFactory activityFactory = injector.getInstance(IActivityFactory.class);
        IPokemonFactory pokemonFactory = injector.getInstance(IPokemonFactory.class);

        List<Characteristic> characteristics = new ArrayList<>();
        dtoPokemon.characteristicsStrings.forEach(string -> characteristics.add(new Characteristic(string, null)));

        return pokemonFactory.create(dtoPokemon.name, characteristics, activityFactory.create(dtoPokemon.activitiesNames));
    }
    private Environment createEnvironmentFromJSON(String fileName,
                                                         ObjectMapper objectMapper) {
        JSONReader<Environment> jsonReader = new JSONReader<>(objectMapper);
        return jsonReader.read(storyTailerConfiguration.environmentJsonDirectory + fileName,
                               Environment.class);
    }
}
