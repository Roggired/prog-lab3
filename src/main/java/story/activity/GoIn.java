package story.activity;

import story.activity.annotations.WithSingleObject;
import story.activity.exception.NoFeatureException;
import story.environment.Environment;
import story.pokemon.Pokemon;

@WithSingleObject
public class GoIn extends Activity {
    public static final String NAME = "идти в";
    private static final String OBJECT_REQUIRED_FEATURE = "можно идти";


    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String executeFor(Pokemon pokemon,
                           Environment... environments) throws NoFeatureException {
        checkObjectRequiredFeature(OBJECT_REQUIRED_FEATURE, environments);

        return pokemon.getName() + " "
                + characteristic.getName()
                + " пошел в " + environments[0].getName();
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
        return NAME.hashCode() + OBJECT_REQUIRED_FEATURE.hashCode();
    }

    @Override
    public String toString() {
        return this.getClass().toString() + NAME + OBJECT_REQUIRED_FEATURE;
    }
}
