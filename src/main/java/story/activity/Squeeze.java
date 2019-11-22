package story.activity;

import story.activity.annotations.WithSingleObject;
import story.activity.exception.ActivityException;
import story.environment.Environment;
import story.pokemon.Pokemon;

@WithSingleObject
public final class Squeeze extends Activity {
    public static final String NAME = "сжать";

    private final String OBJECT_REQUIRED_FEATURE = "это можно сжать";


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
                + " сжал " + environments[0].getName();
    }
}
