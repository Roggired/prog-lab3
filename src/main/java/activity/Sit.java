package activity;

import activity.exception.NoFeatureException;
import activity.exception.NoObjectException;
import activity.exception.TooManyObjectsException;
import environment.Environment;
import pokemon.Pokemon;

import java.io.PrintStream;

public class Sit implements IActivity {
    private static final String NAME = "присесть";


    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void executeFor(PrintStream printStream,
                           Pokemon pokemon,
                           Environment... environments) throws NoObjectException,
            NoFeatureException,
            TooManyObjectsException {
        if (environments.length == 0) {
            throw new NoObjectException(this.getClass() + " Нужен объект, чтобы сесть на него!");
        }

        if (environments.length > 1) {
            throw new TooManyObjectsException(this.getClass() + " Одновременно можно сидеть только на одном объекте!");
        }

        if (!environments[0].haveFeature("можно сидеть")) {
            throw new NoFeatureException(this.getClass() + " Нельзя сидеть на том, на чем нельзя сидеть!");
        }

        String result = pokemon.getName() + " присел на " + environments[0].getName();
        printStream.println(result);
    }
}
