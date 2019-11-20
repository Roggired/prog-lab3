package story.activity;

import story.activity.exception.ActivityException;
import story.activity.exception.NoFeatureException;
import story.environment.Environment;
import story.pokemon.Pokemon;

public class Eat implements IActivity{
    public static final String NAME = "съели";
    private static final String REQUIRED_FEATURE = "это можно съесть";


    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String executeFor(Pokemon pokemon,
                             Environment... environments) throws ActivityException {
        if (!environments[0].haveFeature(REQUIRED_FEATURE)) {
            throw new NoFeatureException("нельзя есть то, что нельзя есть");
        }

        return pokemon.getName() + " съел " + environments[0].getName();
    }
}
