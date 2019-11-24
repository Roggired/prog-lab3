package story.teller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Injector;
import story.activity.*;
import story.activity.exception.ActivityException;
import story.characteristic.Characteristic;
import story.reason.IReasonProducer;
import story.reason.Reason;
import story.reason.ReasonBasedOnActivity;
import story.reason.ReasonBasedOnCharacterisedActivity;
import story.environment.Environment;
import story.pokemon.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class Lab4StoryTeller extends StoryTeller {
    private final String karlsonJsonFileName = "karlson.json",
                         frekenBokJsonFileName = "frekenBok.json",
                         uncleUliusJsonFileName = "uncleUlius.json",
                         witchesJsonFileName = "witches.json",
                         storyTellerJsonFileName = "storyTeller.json",
                         browniesJsonFileName = "brownies.json";

    private final String bakeryKuroschenieJsonFileName = "bakeryKuroschenie.json",
                         frekenBokHandJsonFileName = "frekenBokHand.json",
                         somethingJsonFileName = "something.json",
                         thoughtsJsonFileName = "thoughts.json";


    @Override
    public String tellStory(Injector injector, ObjectMapper objectMapper) throws ActivityException {
        Pokemon karlson = createPokemonFromJSON(karlsonJsonFileName,
                                                objectMapper,
                                                injector);
        Pokemon frekenBok = createPokemonFromJSON(frekenBokJsonFileName,
                                                  objectMapper,
                                                  injector);
        Pokemon uncleUlius = createPokemonFromJSON(uncleUliusJsonFileName,
                                                    objectMapper,
                                                    injector);
        Pokemon witches = createPokemonFromJSON(witchesJsonFileName,
                                                objectMapper,
                                                injector);
        Pokemon storyTeller = createPokemonFromJSON(storyTellerJsonFileName,
                                                    objectMapper,
                                                    injector);
        Pokemon brownies = createPokemonFromJSON(browniesJsonFileName,
                                                 objectMapper,
                                                 injector);

        Environment bakeryKuroschenie = createEnvironmentFromJSON(bakeryKuroschenieJsonFileName,
                                                                  objectMapper,
                                                                  injector);
        bakeryKuroschenie.addCharacteristic(new Characteristic("новое"));
        bakeryKuroschenie.addCharacteristic(new Characteristic("дьявольское"));

        Environment frekenBokHand = createEnvironmentFromJSON(frekenBokHandJsonFileName,
                                                              objectMapper,
                                                              injector);
        Environment something = createEnvironmentFromJSON(somethingJsonFileName,
                                                          objectMapper,
                                                          injector);

        Environment thoughts = createEnvironmentFromJSON(thoughtsJsonFileName,
                                                         objectMapper,
                                                         injector);

        StringBuilder story = new StringBuilder("И теперь ");

        karlson.withEnvironments(bakeryKuroschenie);
        story.append(karlson.doActivity(Make.NAME))
             .append(System.lineSeparator());

        Characteristic characteristic = new Characteristic("этого и");
        frekenBok.withCharacteristic(characteristic);
        story.append(frekenBok.doActivity(NotUnderstand.NAME))
             .append(System.lineSeparator());

        characteristic = new Characteristic("тоже");
        uncleUlius.withCharacteristic(characteristic);
        story.append(uncleUlius.doActivity(NotUnderstand.NAME))
             .append(System.lineSeparator());

        characteristic = new Characteristic("несмотря на всю его дъявольскую силу");
        uncleUlius.withCharacteristic(characteristic);
        uncleUlius.withEnvironments(bakeryKuroschenie);
        story.append(uncleUlius.doActivity(NotNotice.NAME))
             .append(System.lineSeparator());

        characteristic = new Characteristic("а только все");
        uncleUlius.withCharacteristic(characteristic);
        uncleUlius.withEnvironments(something);
        story.append(uncleUlius.doActivity(Think.NAME))
             .append(System.lineSeparator());

        characteristic = new Characteristic("вдруг");
        uncleUlius.withCharacteristic(characteristic);
        uncleUlius.withEnvironments(frekenBokHand);
        story.append(uncleUlius.doActivity(Grab.NAME))
             .append(System.lineSeparator());

        characteristic = new Characteristic("крепко, словно прося о помощи");
        uncleUlius.withCharacteristic(characteristic);
        uncleUlius.withEnvironments(frekenBokHand);
        story.append(uncleUlius.doActivity(Squeeze.NAME))
             .append(System.lineSeparator());

        characteristic = new Characteristic("широко");
        frekenBok.withCharacteristic(characteristic);
        story.append(frekenBok.doActivity(OpenEyes.NAME))
             .append(System.lineSeparator());

        uncleUlius.withEnvironments(frekenBok);
        story.append(uncleUlius.doActivity(BendOver.NAME))
             .append(System.lineSeparator());

        uncleUlius.withEnvironments(frekenBok);
        story.append(uncleUlius.doActivity(LookIntoEyes.NAME))
             .append(System.lineSeparator());


        List<IReasonProducer> reasonProducers = new ArrayList<>();
        reasonProducers.add(frekenBok);
        List<String> activityNames = new ArrayList<>();
        activityNames.add(NotWantSeemPachyderms.NAME);
        Reason reason = new ReasonBasedOnActivity(reasonProducers,
                                                  "",
                                                  activityNames);
        characteristic = new Characteristic("никак", reason);

        frekenBok.withCharacteristic(characteristic);
        story.append(frekenBok.doActivity(HarryConfirm.NAME))
             .append(System.lineSeparator());

        story.append(" что ");
        characteristic = new Characteristic("куда чаще, чем предполагаешь");
        witches.withCharacteristic(characteristic);
        story.append(witches.doActivity(Meet.NAME))
             .append(System.lineSeparator());

        story.append("A");
        List<ReasonBasedOnCharacterisedActivity.ActivityNameCharacteristicPair> activityNameCharacteristicPairs =
                new ArrayList<>();
        characteristic = new Characteristic("как следует");
        activityNameCharacteristicPairs.add(
                new ReasonBasedOnCharacterisedActivity.ActivityNameCharacteristicPair(Think.NAME, characteristic));
        reason = new ReasonBasedOnCharacterisedActivity(null,
                                                        "если",
                                                        activityNameCharacteristicPairs);
        characteristic = new Characteristic("", reason);
        storyTeller.withCharacteristic(characteristic);
        story.append(storyTeller.doActivity(BecomeClear.NAME))
                .append(System.lineSeparator());

        story.append(" что ");
        story.append(brownies.doActivity(Be.NAME))
                .append(System.lineSeparator());

        story.append("Но ");
        characteristic = new Characteristic("тут");
        reasonProducers = new ArrayList<>();
        reasonProducers.add(uncleUlius);
        return story.toString();
    }
}
