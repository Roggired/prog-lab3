package story.activity;

import story.activity.annotations.WithoutSubject;

@WithoutSubject
public class BecomeClear extends Activity {
    public static final String NAME = "станет ясно";


    @Override
    public String getName() {
        return NAME;
    }

    @Override
    protected String appendExecutionResult(String result) {
        result += "станет ясно";

        return result;
    }
}
