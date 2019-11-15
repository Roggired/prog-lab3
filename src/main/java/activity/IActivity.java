package activity;

import activity.exception.ActivityException;
import environment.Environment;
import pokemon.Pokemon;

import java.io.PrintStream;

public interface IActivity {
    String getName();

    String executeFor(Pokemon pokemon,
                      Environment ...environments) throws ActivityException;
}
