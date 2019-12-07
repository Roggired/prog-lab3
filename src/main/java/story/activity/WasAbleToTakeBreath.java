package story.activity;

import story.activity.annotations.WithoutSubject;

@WithoutSubject
public final class WasAbleToTakeBreath extends Activity{
    public WasAbleToTakeBreath(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) {
        result += "смог перевести дух";

        return result;
    }
}
