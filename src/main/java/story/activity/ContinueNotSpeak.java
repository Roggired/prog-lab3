package story.activity;

import story.activity.annotations.WithoutSubject;

@WithoutSubject
public final class ContinueNotSpeak extends Activity{
    public ContinueNotSpeak(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) {
        result += "продолжали молчать";

        return result;
    }
}
