package story.activity;

import story.activity.annotations.WithSingleObject;
import story.activity.exception.ActivityException;
import story.activity.exception.NoFeatureException;
import story.environment.Environment;
import story.pokemon.Pokemon;

@WithSingleObject
public class GoOver implements IActivity {
    public static final String NAME = "перемахнуть";
    private static final String REQUIRED_FEATURE = "можно перемахнуть";


    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String executeFor(Pokemon pokemon,
                           Environment... environments) throws ActivityException {
        if (!environments[0].haveFeature(REQUIRED_FEATURE)) {
            throw new NoFeatureException("Нельзя перемахнуть через то, через что нельзя");
        }

        return pokemon.getName() + " перемахнул через " + environments[0].getName();
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }

        if (!(object instanceof GoOver)) {
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
