package story.activity;

import story.activity.annotations.WithoutSubject;

@WithoutSubject
public final class EyesBecomeRound extends Activity{
    public EyesBecomeRound(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) {
        result += "у " + pokemon.getName() + " глаза округлились от удивления";

        return result;
    }
}
