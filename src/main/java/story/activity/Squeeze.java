package story.activity;

import story.activity.annotations.WithSingleObject;
import story.activity.exception.ActivityException;

@WithSingleObject
public final class Squeeze extends Activity {
    public static final String NAME = "сжать";

    private final String OBJECT_REQUIRED_FEATURE = "это можно сжать";


    @Override
    public String getName() {
        return NAME;
    }

    @Override
    protected String appendExecutionResult(String result) throws ActivityException {
        checkObjectRequiredFeature(OBJECT_REQUIRED_FEATURE, environments);

        result += "сжал " + environments[0].getName();

        return result;
    }
}
