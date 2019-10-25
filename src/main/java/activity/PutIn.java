package activity;

import activity.annotations.WithTwoObject;
import activity.exception.ActivityException;
import activity.exception.NoFeatureException;
import environment.Environment;
import pokemon.Pokemon;

import java.io.PrintStream;

@WithTwoObject
public class PutIn implements IActivity {
    public static final String NAME = "положить в";
    public static final String OBJECT_REQUIRED_FEATURE = "это можно положить";
    public static final String CONTAINER_REQUIRED_FEATURE = "в это можно положить";


    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void executeFor(PrintStream printStream,
                           Pokemon pokemon,
                           Environment... environments) throws ActivityException {
        if (!environments[0].haveFeature(OBJECT_REQUIRED_FEATURE)) {
            throw new NoFeatureException("Нельзя положить то, что нельзя");
        }

        if (!environments[1].haveFeature(CONTAINER_REQUIRED_FEATURE)) {
            throw new NoFeatureException("Нельзя положить в то, во что нельзя");
        }

        String result = pokemon.getName() + " положил " + environments[0].getName() + " в " + environments[1].getName();
        printStream.println(result);
    }
}
