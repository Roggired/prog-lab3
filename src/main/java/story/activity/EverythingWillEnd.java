package story.activity;

import story.activity.annotations.WithoutSubject;

@WithoutSubject
public final class EverythingWillEnd extends Activity{
    public EverythingWillEnd(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) {
        result += "всему наступит конец";

        return result;
    }
}
