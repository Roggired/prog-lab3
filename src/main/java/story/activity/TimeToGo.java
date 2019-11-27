package story.activity;

import story.activity.exception.ActivityException;

public class TimeToGo extends Activity {
    public static final String NAME = "пора было уходить";


    @Override
    public String getName() {
        return NAME;
    }

    @Override
    protected String appendExecutionResult(String result) {
        result += "пора было уходить";

        return result;
    }
}
