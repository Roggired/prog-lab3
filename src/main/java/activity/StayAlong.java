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
    public String executeFor(Pokemon pokemon,
                           Environment... environments) {
        return pokemon.getName() + " остался один";
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }

        if (!(object instanceof StayAlong)) {
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
