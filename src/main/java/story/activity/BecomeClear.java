package story.activity;

import story.activity.annotations.WithoutSubject;

@WithoutSubject
public final class BecomeClear extends Activity {
    public static final String NAME = "станет ясно";


    public BecomeClear(String name, String... requirements) {
        super(name, requirements);
    }


    @Override
    protected String appendExecutionResult(String result) {
        result += "станет ясно";

        return result;
    }
}
