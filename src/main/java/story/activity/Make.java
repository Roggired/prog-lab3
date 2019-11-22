package story.activity;

import story.activity.annotations.WithSingleObject;
import story.activity.exception.ActivityException;

@WithSingleObject
public final class Make extends Activity {
    public static final String NAME = "сделать";

    private final String OBJECT_REQUIRED_FEATURE = "это можно сделать";


    @Override
    public String getName() {
        return NAME;
    }

    @Override
    protected String appendExecutionResult(String result) throws ActivityException {
        checkObjectRequiredFeature(OBJECT_REQUIRED_FEATURE, environments);

        result += "сделал " + environments[0].getName();

        return result;
    }
}
