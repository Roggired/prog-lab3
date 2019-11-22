package story.activity;

import story.activity.exception.ActivityException;

public class Eat extends Activity{
    public static final String NAME = "съели";
    private static final String OBJECT_REQUIRED_FEATURE = "это можно съесть";


    @Override
    public String getName() {
        return NAME;
    }

    @Override
    protected String appendExecutionResult(String result) throws ActivityException {
        checkObjectRequiredFeature(OBJECT_REQUIRED_FEATURE, environments);

        result += "съел " + environments[0].getName();

        return result;
    }
}
