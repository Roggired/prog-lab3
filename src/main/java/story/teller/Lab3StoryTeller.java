package story.teller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Injector;
import story.activity.*;
import story.activity.exception.ActivityException;
import story.characteristic.Characteristic;
import story.reason.IReasonProducer;
import story.reason.Reason;
import story.reason.ReasonBasedOnActivity;
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

        fille.withEnvironments(hall);
        result.append(fille.doActivity(GoIn.NAME))
                .append(System.lineSeparator());

        rulle.withEnvironments(hall);
        result.append(rulle.doActivity(GoIn.NAME))
                .append(System.lineSeparator());

        result.append(oskar.doActivity(StayAlong.NAME))
                .append(System.lineSeparator());

        result.append(oskar.doActivity(Bore.NAME))
                .append(System.lineSeparator());

        Characteristic characteristic = new Characteristic("Чтобы посмотреть, что делают его новые друзья");
        oskar.withCharacteristic(characteristic);
        oskar.withEnvironments(hall);
        result.append(oskar.doActivity(GoIn.NAME))
                .append(System.lineSeparator());

        karlson.withEnvironments(underWindow);
        result.append(karlson.doActivity(GoOver.NAME))
                .append(System.lineSeparator());

        karlson.withEnvironments(wallet, soupBowl);
        result.append(karlson.doActivity(PutIn.NAME))
                .append(System.lineSeparator());

        fille.withEnvironments(soup);
        fille.doActivity(Eat.NAME);

        rulle.withEnvironments(soup);
        rulle.doActivity(Eat.NAME);

        oskar.withEnvironments(soup);
        oskar.doActivity(Eat.NAME);


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


        karlson.withEnvironments(watches, lamp);
        result.append(karlson.doActivity(AttachTo.NAME))
                .append(System.lineSeparator());


        watches.addCharacteristic(new Characteristic("висели на виду, слегка раскачиваясь"));

        result.append(watches.getName())
                .append(System.lineSeparator());


        characteristic = new Characteristic("когда вернулся в комнату");

        fille.withCharacteristic(characteristic);
        fille.withEnvironments(watches);
        result.append(fille.doActivity(See.NAME))
                .append(System.lineSeparator());

        rulle.withCharacteristic(characteristic);
        rulle.withEnvironments(watches);
        result.append(rulle.doActivity(See.NAME))
                .append(System.lineSeparator());

        oskar.withCharacteristic(characteristic);
        oskar.withEnvironments(watches);
        result.append(oskar.doActivity(See.NAME))
                .append(System.lineSeparator());

        result.append(System.lineSeparator());
        result.append(System.lineSeparator());

        return result.toString();
    }
}
