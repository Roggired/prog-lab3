package story.activity;

import story.activity.annotations.WithSingleObject;
import story.activity.exception.ActivityException;

@WithSingleObject
public class GoOver extends Activity {
    public static final String NAME = "перемахнуть";
    private static final String OBJECT_REQUIRED_FEATURE = "можно перемахнуть";


    @Override
    public String getName() {
        return NAME;
    }

    @Override
    protected String appendExecutionResult(String result) throws ActivityException {
        checkObjectRequiredFeature(OBJECT_REQUIRED_FEATURE, environments);

        result += "перемахнул через " + environments[0].getName();

        return result;
    }
}
