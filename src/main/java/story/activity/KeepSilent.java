package story.activity;

public final class KeepSilent extends Activity {
    public KeepSilent(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) {
        result += "молчал";

        return result;
    }
}
