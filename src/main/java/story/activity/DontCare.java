package story.activity;

public final class DontCare extends Activity {
    public DontCare(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) {
        result += "на это плевать";

        return result;
    }
}
