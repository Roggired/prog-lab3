package story.activity;

import story.activity.annotations.WithTwoObject;
import story.activity.exception.ActivityException;
import story.activity.exception.NoFeatureException;
import story.environment.Environment;
import story.pokemon.Pokemon;

@WithTwoObject
public class AttachTo implements IActivity {
    public static final String NAME = "прикрепить к";
    private static final String OBJECT_REQUIRED_FEATURE = "это можно прикрепить";
    private static final String CONTAINER_REQUIRED_FEATURE = "к этому можно прикрепить";


    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String executeFor(Pokemon pokemon,
                           Environment... environments) throws ActivityException {
        if (!environments[0].haveFeature(OBJECT_REQUIRED_FEATURE)) {
            throw new NoFeatureException("Нельзя прикрепить то, что нельзя");
        }

        if (!environments[1].haveFeature(CONTAINER_REQUIRED_FEATURE)) {
            throw new NoFeatureException("Нельзя прикрепить к тому, к чему нельзя");
        }

        return pokemon.getName() + " прикрепил " + environments[0].getName() + " к " + environments[1].getName();
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }

        if (!(object instanceof AttachTo)) {
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
