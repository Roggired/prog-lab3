package story.activity;

import story.activity.annotations.WithoutSubject;

@WithoutSubject
public final class DontClimbRoofs extends Activity{
    public DontClimbRoofs(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) {
        result += "не лазает по крышам";

        return result;
    }
}
