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
        Pokemon uncleUnlius = createPokemonFromJSON(uncleUliusJsonFileName,
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
        story.append(karlson.doActivity(Make.NAME, bakeryKuroschenie))
             .append(System.lineSeparator());

        Characteristic characteristic = new Characteristic("этого и");
        story.append(frekenBok.doActivity(NotUnderstand.NAME, characteristic))
             .append(System.lineSeparator());

        characteristic = new Characteristic("тоже");
        story.append(uncleUnlius.doActivity(NotUnderstand.NAME, characteristic))
             .append(System.lineSeparator());

        characteristic = new Characteristic("несмотря на всю его дъявольскую силу");
        story.append(uncleUnlius.doActivity(NotNotice.NAME,
                                            characteristic,
                                            bakeryKuroschenie))
             .append(System.lineSeparator());

        characteristic = new Characteristic("а только все");
        story.append(uncleUnlius.doActivity(Think.NAME,
                                            characteristic,
                                            something))
             .append(System.lineSeparator());

        characteristic = new Characteristic("вдруг");
        story.append(uncleUnlius.doActivity(Grab.NAME,
                                            characteristic,
                                            frekenBokHand))
             .append(System.lineSeparator());

        characteristic = new Characteristic("крепко, словно прося о помощи");
        story.append(uncleUnlius.doActivity(Squeeze.NAME,
                                            characteristic,
                                            frekenBokHand))
             .append(System.lineSeparator());

        characteristic = new Characteristic("широко");
        story.append(frekenBok.doActivity(OpenEyes.NAME,
                                          characteristic))
             .append(System.lineSeparator());

        story.append(uncleUnlius.doActivity(BendOver.NAME, frekenBok))
             .append(System.lineSeparator());

        story.append(uncleUnlius.doActivity(LookIntoEyes.NAME, frekenBok))
             .append(System.lineSeparator());


        List<IReasonProducer> reasonProducers = new ArrayList<>();
        reasonProducers.add(frekenBok);
        List<String> activityNames = new ArrayList<>();
        activityNames.add(NotWantSeemPachyderms.NAME);
        Reason reason = new ReasonBasedOnActivity(reasonProducers,
                                                  "",
                                                  activityNames);
        characteristic = new Characteristic("никак", reason);

        story.append(frekenBok.doActivity(HarryConfirm.NAME, characteristic))
             .append(System.lineSeparator());

        story.append(" что ");
        characteristic = new Characteristic("куда чаще, чем предполагаешь");
        story.append(witches.doActivity(Meet.NAME, characteristic))
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
        story.append(storyTeller.doActivity(BecomeClear.NAME,
                                            characteristic))
                .append(System.lineSeparator());

        story.append(" что ");
        story.append(brownies.doActivity(Be.NAME))
                .append(System.lineSeparator());

        return story.toString();
    }
}
