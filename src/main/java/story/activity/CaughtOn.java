package story.activity;


public final class CaughtOn extends Activity {
    public CaughtOn(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) {
        result += "спохватился";

        return result;
    }
}
