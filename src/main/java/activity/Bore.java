package activity;

import activity.exception.ActivityException;
import environment.Environment;
import pokemon.Pokemon;

import java.io.PrintStream;

public class Bore implements IActivity {
    public static final String NAME = "скучать";


    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void executeFor(PrintStream printStream,
                           Pokemon pokemon,
                           Environment... environments) {
        String result = pokemon.getName() + " заскучал";
        printStream.println(result);
    }
}
