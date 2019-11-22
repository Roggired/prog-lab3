package story.activity;

import story.activity.annotations.WithSingleObject;

@WithSingleObject
public final class Think extends Activity {
    public static final String NAME = "думать";


    @Override
    public String getName() {
        return NAME;
    }

    @Override
    protected String appendExecutionResult(String result) {
        result += "думал о " + environments[0].getName();

        return result;
    }
}
