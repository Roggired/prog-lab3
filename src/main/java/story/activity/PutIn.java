package story.activity;

import story.activity.annotations.WithTwoObject;
import story.activity.exception.ActivityException;

@WithTwoObject
public class PutIn extends Activity {
    public static final String NAME = "положить в";
    private static final String OBJECT_REQUIRED_FEATURE = "это можно положить";
    private static final String CONTAINER_REQUIRED_FEATURE = "в это можно положить";


    @Override
    public String getName() {
        return NAME;
    }

    @Override
    protected String appendExecutionResult(String result) throws ActivityException {
        checkObjectRequiredFeature(OBJECT_REQUIRED_FEATURE, environments);
        checkContainerRequiredFeature(CONTAINER_REQUIRED_FEATURE, environments);

        result += "положил " + environments[0].getName() + " в " + environments[1].getName();

        return result;
    }
}
