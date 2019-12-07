package story.activity;


public final class ArousedCompassion extends Activity {
    public ArousedCompassion(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) {
        result += "вызвал сострадание";

        return result;
    }
}
