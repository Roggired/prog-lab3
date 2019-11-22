package story.teller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Injector;
import story.activity.*;
import story.activity.exception.ActivityException;
import story.characteristic.Characteristic;
import story.characteristic.reason.IReasonProducer;
import story.characteristic.reason.Reason;
import story.characteristic.reason.ReasonBasedOnActivity;
import story.environment.Environment;
import story.pokemon.Pokemon;

import java.util.ArrayList;
import java.util.List;

public final class Lab3StoryTeller extends StoryTeller {
    private final String filleJsonFileName = "fille.json",
                         rulleJsonFileName = "rulle.json",
                         oskarJsonFileName = "oskar.json",
                         karlsonJsonFileName = "karlson.json";

    private final String hallJsonFileName = "hall.json",
                         underWindowJsonFileName = "underWindow.json",
                         walletJsonFileName = "wallet.json",
                         soupBowlJsonFileName = "soupBowl.json",
                         soupJsonFileName = "soup.json",
                         watchesJsonFileName = "watches.json",
                         lampJsonFileName = "lamp.json";

    @Override
    public String tellStory(Injector injector, ObjectMapper objectMapper) throws ActivityException {
        Pokemon fille = createPokemonFromJSON(filleJsonFileName,
                                              objectMapper,
                                              injector);
        Pokemon rulle = createPokemonFromJSON(rulleJsonFileName,
                                              objectMapper,
                                              injector);
        Pokemon oskar = createPokemonFromJSON(oskarJsonFileName,
                                              objectMapper,
                                              injector);
        Pokemon karlson = createPokemonFromJSON(karlsonJsonFileName,
                                                objectMapper,
                                                injector);

        Environment hall = createEnvironmentFromJSON(hallJsonFileName,
                                                     objectMapper,
                                                     injector);
        Environment underWindow = createEnvironmentFromJSON(underWindowJsonFileName,
                                                            objectMapper,
                                                            injector);
        Environment wallet = createEnvironmentFromJSON(walletJsonFileName,
                                                       objectMapper,
                                                       injector);
        Environment soupBowl = createEnvironmentFromJSON(soupBowlJsonFileName,
                                                         objectMapper,
                                                         injector);
        Environment soup = createEnvironmentFromJSON(soupJsonFileName,
                                                     objectMapper,
                                                     injector);
        Environment watches = createEnvironmentFromJSON(watchesJsonFileName,
                                                        objectMapper,
                                                        injector);
        Environment lamp = createEnvironmentFromJSON(lampJsonFileName,
                                                     objectMapper,
                                                     injector);

        StringBuilder result = new StringBuilder();
        result.append(fille.doActivity(GoIn.NAME, hall))
                .append(System.lineSeparator());
        result.append(rulle.doActivity(GoIn.NAME, hall))
                .append(System.lineSeparator());
        result.append(oskar.doActivity(StayAlong.NAME))
                .append(System.lineSeparator());
        result.append(oskar.doActivity(Bore.NAME))
                .append(System.lineSeparator());
        Characteristic characteristic = new Characteristic("Чтобы посмотреть, что делают его новые друзья");
        result.append(oskar.doActivity(GoIn.NAME,
                                       characteristic,
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
        Reason reason = new ReasonBasedOnActivity(reasonProducers,
                                                  "потому что",
                                                  activityNames);
        characteristic = new Characteristic("сухой", reason);
        wallet.addCharacteristic(characteristic);

        result.append(wallet.getName())
                .append(System.lineSeparator());
        result.append(karlson.doActivity(AttachTo.NAME, watches, lamp))
                .append(System.lineSeparator());

        watches.addCharacteristic(new Characteristic("висели на виду, слегка раскачиваясь"));

        result.append(watches.getName())
                .append(System.lineSeparator());
        characteristic = new Characteristic("Когда вернулся в комнату");
        result.append(fille.doActivity(See.NAME,
                                       characteristic,
                                       watches))
                .append(System.lineSeparator());
        result.append(rulle.doActivity(See.NAME,
                                       characteristic,
                                       watches))
                .append(System.lineSeparator());
        result.append(oskar.doActivity(See.NAME,
                                       characteristic,
                                       watches))
                .append(System.lineSeparator());

        result.append(System.lineSeparator());
        result.append(System.lineSeparator());

        return result.toString();
    }
}
