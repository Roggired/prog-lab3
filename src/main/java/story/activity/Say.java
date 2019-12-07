package story.activity;


public final class Say extends Activity {
    public Say(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) {
        result += "сказал";

        return result;
    }
}
