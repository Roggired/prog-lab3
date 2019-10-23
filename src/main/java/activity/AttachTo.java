package activity;

import activity.annotations.WithTwoObject;
import activity.exception.ActivityException;
import activity.exception.NoFeatureException;
import environment.Environment;
import pokemon.Pokemon;

import java.io.PrintStream;

@WithTwoObject
public class AttachTo implements IActivity {
    public static final String NAME = "прикрепить к";


    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void executeFor(PrintStream printStream,
                           Pokemon pokemon,
                           Environment... environments) throws ActivityException {
        if (!environments[0].haveFeature("это можно прикрепить")) {
            throw new NoFeatureException("Нельзя прикрепить то, что нельзя");
        }

        if (!environments[1].haveFeature("к этому можно прикрепить")) {
            throw new NoFeatureException("Нельзя прикрепить к тому, к чему нельзя");
        }

        String result = pokemon.getName() + " прикрепил " + environments[0].getName() + " к " + environments[1].getName();
        printStream.println(result);
    }
}
