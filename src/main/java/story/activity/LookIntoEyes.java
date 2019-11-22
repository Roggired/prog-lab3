package story.activity;

import story.activity.annotations.WithSingleObject;
import story.activity.exception.ActivityException;

@WithSingleObject
public class LookIntoEyes extends Activity {
    public static final String NAME = "заглянуться в глаза";

    private final String OBJECT_REQUIRED_FEATURE = "этому можно заглянуть в глаза";


    @Override
    public String getName() {
        return NAME;
    }

    @Override
    protected String appendExecutionResult(String result) throws ActivityException {
        checkObjectRequiredFeature(OBJECT_REQUIRED_FEATURE, environments);

        result += "заглянул в глаза " + environments[0].getName();

        return result;
    }
}
