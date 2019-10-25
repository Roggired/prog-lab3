package activity;

import activity.annotations.WithSingleObject;
import activity.exception.ActivityException;
import activity.exception.NoFeatureException;
import environment.Environment;
import pokemon.Pokemon;

import java.io.PrintStream;

@WithSingleObject
public class GoOver implements IActivity {
    public static final String NAME = "перемахнуть";
    public static final String REQUIRED_FEATURE = "можно перемахнуть";


    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void executeFor(PrintStream printStream,
                           Pokemon pokemon,
                           Environment... environments) throws ActivityException {
        if (!environments[0].haveFeature(REQUIRED_FEATURE)) {
            throw new NoFeatureException("Нельзя перемахнуть через то, через что нельзя");
        }

        String result = pokemon.getName() + " перемахнул через " + environments[0].getName();
        printStream.println(result);
    }
}
