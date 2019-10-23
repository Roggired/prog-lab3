package activity;

import activity.annotations.WithSingleObject;
import activity.exception.NoFeatureException;
import environment.Environment;
import pokemon.Pokemon;

import java.io.PrintStream;

@WithSingleObject
public class Go implements IActivity {
    public static final String NAME = "идти";


    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void executeFor(PrintStream printStream,
                           Pokemon pokemon,
                           Environment... environments) throws NoFeatureException {
        if (!environments[0].haveFeature("можно идти")) {
            throw new NoFeatureException("нельзя идти туда, куда нельзя идти");
        }

        String result = pokemon.getName() + " пошел в " + environments[0].getName();
        printStream.println(result);
    }
}
