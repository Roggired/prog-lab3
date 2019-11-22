package story.activity;

import story.activity.annotations.WithSingleObject;
import story.activity.exception.ActivityException;

@WithSingleObject
public class GoIn extends Activity {
    public static final String NAME = "идти в";
    private static final String OBJECT_REQUIRED_FEATURE = "можно идти";


    @Override
    public String getName() {
        return NAME;
    }

    @Override
    protected String appendExecutionResult(String result) throws ActivityException {
        checkObjectRequiredFeature(OBJECT_REQUIRED_FEATURE, environments);

        result += "пошел в " + environments[0].getName();

        return result;
    }
}
