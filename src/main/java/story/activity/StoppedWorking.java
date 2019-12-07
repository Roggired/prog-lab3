package story.activity;

import story.activity.annotations.WithoutSubject;

@WithoutSubject
public final class StoppedWorking extends Activity{
    public StoppedWorking(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) {
        result += "это перестало удаваться";

        return result;
    }
}
