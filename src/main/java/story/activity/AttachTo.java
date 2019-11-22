package story.activity;

import story.activity.annotations.WithTwoObject;
import story.activity.exception.ActivityException;
import story.activity.exception.NoFeatureException;
import story.environment.Environment;
import story.pokemon.Pokemon;

@WithTwoObject
public class AttachTo extends Activity {
    public static final String NAME = "прикрепить к";
    private static final String OBJECT_REQUIRED_FEATURE = "это можно прикрепить";
    private static final String CONTAINER_REQUIRED_FEATURE = "к этому можно прикрепить";


    @Override
    public String getName() {
        return NAME;
    }

    @Override
    protected String appendExecutionResult(String result) throws ActivityException {
        checkObjectRequiredFeature(OBJECT_REQUIRED_FEATURE, environments);
        checkContainerRequiredFeature(CONTAINER_REQUIRED_FEATURE, environments);

        result += " прикрепил " + environments[0].getName() + " к " + environments[1].getName();

        return result;
    }
}
