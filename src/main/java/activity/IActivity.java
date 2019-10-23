package activity;

import activity.exception.ActivityException;
import environment.Environment;
import pokemon.Pokemon;

import java.io.PrintStream;

public interface IActivity {
    String getName();

    void executeFor(PrintStream printStream,
                    Pokemon pokemon,
                    Environment ...environments) throws ActivityException;
}
