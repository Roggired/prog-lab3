package activity;

import activity.exception.ActivityException;
import environment.Environment;
import pokemon.Pokemon;

import java.io.PrintStream;
import java.util.Arrays;

public class See implements IActivity {
    public static final String NAME = "увидеть";


    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void executeFor(PrintStream printStream,
                           Pokemon pokemon,
                           Environment... environments) {
        if (environments.length == 0) {
            String result = pokemon.getName() + " ничего не увидел";
            printStream.println(result);
        }

        StringBuilder stringBuilder = new StringBuilder(pokemon.getName() + " увидел: ");
        Arrays.asList(environments).forEach(environment -> stringBuilder.append(environment.getName() + " "));
        printStream.println(stringBuilder.toString());
    }
}
