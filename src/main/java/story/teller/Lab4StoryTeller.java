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

public class Lab4StoryTeller extends StoryTeller {
    private final String karlsonJsonFileName = "karlson.json",
                         frekenBokJsonFileName = "frekenBok.json",
                         uncleUliusJsonFileName = "uncleUlius.json",
                         witchesJsonFileName = "witches.json";

    private final String bakeryKuroschenieJsonFileName = "bakeryKuroschenie.json",
                         frekenBokHandJsonFileName = "frekenBokHand.json",
                         somethingJsonFileName = "something.json";


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

        StringBuilder story = new StringBuilder("И теперь ");
        story.append(karlson.doActivity(Make.NAME, bakeryKuroschenie))
             .append(System.lineSeparator());

        story.append(frekenBok.doActivity(NotUnderstand.NAME))
             .append(System.lineSeparator());

        story.append(uncleUnlius.doActivity(NotUnderstand.NAME))
             .append(System.lineSeparator());

        story.append(uncleUnlius.doActivity(NotNotice.NAME, bakeryKuroschenie))
             .append(System.lineSeparator());

        story.append(uncleUnlius.doActivity(Think.NAME, something))
             .append(System.lineSeparator());

        story.append(uncleUnlius.doActivity(Grab.NAME, frekenBokHand))
             .append(System.lineSeparator());

        story.append(uncleUnlius.doActivity(Squeeze.NAME, frekenBokHand))
             .append(System.lineSeparator());

        Characteristic characteristic = new Characteristic("широко");
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



        return story.toString();
    }
}
