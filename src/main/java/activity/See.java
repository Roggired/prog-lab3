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
    public String executeFor(Pokemon pokemon,
                           Environment... environments) {
        if (environments.length == 0) {
            return pokemon.getName() + " ничего не увидел";
        }

        StringBuilder stringBuilder = new StringBuilder(pokemon.getName() + " увидел: ");
        Arrays.asList(environments).forEach(environment -> stringBuilder.append(environment.getName()).append(" "));
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }

        if (!(object instanceof See)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return NAME.hashCode();
    }

    @Override
    public String toString() {
        return this.getClass().toString() + NAME;
    }
}
