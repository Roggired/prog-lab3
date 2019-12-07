package story.activity;

import story.activity.annotations.WithoutSubject;

@WithoutSubject
public final class BeHereInSafity extends Activity{
    public BeHereInSafity(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) {
        result += "быть там в полной безопасности";

        return result;
    }
}
