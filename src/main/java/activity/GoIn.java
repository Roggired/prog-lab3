package activity;

import activity.annotations.WithSingleObject;
import activity.exception.NoFeatureException;
import environment.Environment;
import pokemon.Pokemon;

import java.io.PrintStream;

@WithSingleObject
public class GoIn implements IActivity {
    public static final String NAME = "идти в";
    private static final String REQUIRED_FEATURE = "можно идти";


    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String executeFor(Pokemon pokemon,
                           Environment... environments) throws NoFeatureException {
        if (!environments[0].haveFeature(REQUIRED_FEATURE)) {
            throw new NoFeatureException("нельзя идти туда, куда нельзя идти");
        }

        return pokemon.getName() + " пошел в " + environments[0].getName();
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }

        if (!(object instanceof GoIn)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return NAME.hashCode() + REQUIRED_FEATURE.hashCode();
    }

    @Override
    public String toString() {
        return this.getClass().toString() + NAME + REQUIRED_FEATURE;
    }
}
