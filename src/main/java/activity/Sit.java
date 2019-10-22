package activity;

import activity.annotations.WithSingleObject;
import activity.exception.NoFeatureException;
import activity.exception.NoObjectException;
import activity.exception.TooManyObjectsException;
import environment.Environment;
import pokemon.Pokemon;

import java.io.PrintStream;

@WithSingleObject
public class Sit implements IActivity {
    public static final String NAME = "присесть";


    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void executeFor(PrintStream printStream,
                           Pokemon pokemon,
                           Environment... environments) throws NoFeatureException {
        if (!environments[0].haveFeature("можно сидеть")) {
            throw new NoFeatureException(this.getClass() + " Нельзя сидеть на том, на чем нельзя сидеть!");
        }

        String result = pokemon.getName() + " присел на " + environments[0].getName();
        printStream.println(result);
    }
}
