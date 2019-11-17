package story.activity;

import story.activity.annotations.WithTwoObject;
import story.activity.exception.ActivityException;
import story.activity.exception.NoFeatureException;
import story.environment.Environment;
import story.pokemon.Pokemon;

@WithTwoObject
public class PutIn implements IActivity {
    public static final String NAME = "положить в";
    private static final String OBJECT_REQUIRED_FEATURE = "это можно положить";
    private static final String CONTAINER_REQUIRED_FEATURE = "в это можно положить";


    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String executeFor(Pokemon pokemon,
                           Environment... environments) throws ActivityException {
        if (!environments[0].haveFeature(OBJECT_REQUIRED_FEATURE)) {
            throw new NoFeatureException("Нельзя положить то, что нельзя");
        }

        if (!environments[1].haveFeature(CONTAINER_REQUIRED_FEATURE)) {
            throw new NoFeatureException("Нельзя положить в то, во что нельзя");
        }

        return pokemon.getName() + " положил " + environments[0].getName() + " в " + environments[1].getName();
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }

        if (!(object instanceof PutIn)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return NAME.hashCode() + OBJECT_REQUIRED_FEATURE.hashCode() + CONTAINER_REQUIRED_FEATURE.hashCode();
    }

    @Override
    public String toString() {
        return this.getClass().toString() + NAME + OBJECT_REQUIRED_FEATURE + CONTAINER_REQUIRED_FEATURE;
    }
}
