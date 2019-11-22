package story.activity;

import story.activity.annotations.WithSingleObject;

@WithSingleObject
public final class NotNotice extends Activity {
    public static final String NAME = "не замечать";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    protected String appendExecutionResult(String result) {
        result += "не заметил " + environments[0].getName();

        return result;
    }
}
