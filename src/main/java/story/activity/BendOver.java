package story.activity;

import story.activity.annotations.WithSingleObject;
import story.activity.exception.ActivityException;

@WithSingleObject
public class BendOver extends Activity {
    public static final String NAME = "наклониться";

    private final String OBJECT_REQUIRED_FEATURE = "к этому можно наклониться";


    @Override
    public String getName() {
        return NAME;
    }

    @Override
    protected String appendExecutionResult(String result) throws ActivityException {
        checkObjectRequiredFeature(OBJECT_REQUIRED_FEATURE, environments);

        result += " наклонился к " + environments[0].getName();

        return result;
    }
}
