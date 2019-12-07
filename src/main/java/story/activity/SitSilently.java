package story.activity;

import story.activity.annotations.WithoutSubject;

@WithoutSubject
public final class SitSilently extends Activity {
    public SitSilently(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) {
        result += "сидят себе молчат";

        return result;
    }
}
