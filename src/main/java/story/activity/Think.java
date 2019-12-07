package story.activity;

import story.activity.annotations.WithoutSubject;

@WithoutSubject
public final class Think extends Activity {
    public Think(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) {
        return result += "думать";
    }
}
