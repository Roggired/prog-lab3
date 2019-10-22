package activity;

import activity.exception.NoFeatureException;
import activity.exception.NoObjectException;
import activity.exception.TooManyObjectsException;
import environment.Environment;
import pokemon.Pokemon;

import java.io.PrintStream;

public class Go implements IActivity {
    private static final String NAME = "идти";


    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void executeFor(PrintStream printStream,
                           Pokemon pokemon,
                           Environment... environments) throws NoObjectException, NoFeatureException, TooManyObjectsException {
        if (environments.length == 0) {
            throw new NoObjectException("нужно место, куда можно идти");
        }

        if (environments.length > 1) {
            throw new TooManyObjectsException("нельзя сразу идти в несколько мест");
        }

        if (!environments[0].haveFeature("можно идти")) {
            throw new NoFeatureException("нельзя идти туда, куда нельзя идти");
        }

        String result = pokemon.getName() + " пошел в\\на " + environments[0].getName();
        printStream.println(result);
    }
}
