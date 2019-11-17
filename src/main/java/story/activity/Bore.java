package story.activity;

import story.environment.Environment;
import story.pokemon.Pokemon;

public class Bore implements IActivity {
    public static final String NAME = "скучать";


    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String executeFor(Pokemon pokemon,
                           Environment... environments) {
        return pokemon.getName() + " заскучал";
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }

        if (!(object instanceof Bore)) {
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
