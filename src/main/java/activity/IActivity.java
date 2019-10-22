package activity;

import activity.exception.NoFeatureException;
import activity.exception.NoObjectException;
import activity.exception.TooManyObjectsException;
import environment.Environment;
import pokemon.Pokemon;

import java.io.PrintStream;

public interface IActivity {
    String getName();

    void executeFor(PrintStream printStream,
                    Pokemon pokemon,
                    Environment ...environments) throws NoObjectException, NoFeatureException, TooManyObjectsException;
}
