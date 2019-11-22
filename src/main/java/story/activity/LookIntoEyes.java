package story.activity;

import story.activity.annotations.WithSingleObject;
import story.activity.exception.ActivityException;
import story.environment.Environment;
import story.pokemon.Pokemon;

@WithSingleObject
public class LookIntoEyes extends Activity {
    public static final String NAME = "заглянуться в глаза";

    private final String OBJECT_REQUIRED_FEATURE = "этому можно заглянуть в глаза";


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
                + " заглянул в глаза "
                + environments[0].getName();
    }
}
