package story.activity;

import story.activity.annotations.WithSingleObject;
import story.activity.exception.ActivityException;

@WithSingleObject
public class HaveToAbort extends Activity {
    public static final String NAME = "пришлось прервать";

    private final String OBJECT_REQUIRED_FEATURE = "это можно прервать";


    @Override
    public String getName() {
        return NAME;
    }

    @Override
    protected String appendExecutionResult(String result) throws ActivityException {
        checkObjectRequiredFeature(OBJECT_REQUIRED_FEATURE, environments);

        result += "пришлось прервать" + " " + environments[0].getName();

        return result;
    }
}
