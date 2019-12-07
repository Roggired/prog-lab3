package story.activity;

public final class NeedToKnow extends Activity {
    public NeedToKnow(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) {
        result += "надо было узнать";

        return result;
    }
}
