package activity;

import environment.Environment;
import pokemon.Pokemon;

import java.io.PrintStream;

public class StayAlong implements IActivity {
    public static final String NAME = "остаться одному";


    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void executeFor(PrintStream printStream,
                           Pokemon pokemon,
                           Environment... environments) {
        String result = pokemon.getName() + " остался один";
        printStream.println(result);
    }
}
