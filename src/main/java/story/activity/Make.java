package story.activity;

import story.activity.exception.ActivityException;
import story.environment.Environment;
import story.pokemon.Pokemon;

public class Make extends Activity {
    public static final String NAME = "сделать";

    private static final int ENVIRONMENTS_AMOUNT = 1;
    private static final String OBJECT_REQUIRED_FEATURE = "это можно сделать";


    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String executeFor(Pokemon pokemon,
                             Environment... environments) throws ActivityException {
        checkEnougthEnvironments(ENVIRONMENTS_AMOUNT, environments);
        checkObjectRequiredFeature(OBJECT_REQUIRED_FEATURE, environments);

        return pokemon.getName() + " сделал " + environments[0].getName();
    }
}
