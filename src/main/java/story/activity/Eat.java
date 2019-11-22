package story.activity;

import story.activity.exception.ActivityException;
import story.environment.Environment;
import story.pokemon.Pokemon;

public class Eat extends Activity{
    public static final String NAME = "съели";
    private static final String OBJECT_REQUIRED_FEATURE = "это можно съесть";


    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String executeFor(Pokemon pokemon,
                             Environment... environments) throws ActivityException {
        checkObjectRequiredFeature(OBJECT_REQUIRED_FEATURE, environments);

        return pokemon.getName() + " "
                + characteristic.getName()
                + " съел " + environments[0].getName();
    }
}
