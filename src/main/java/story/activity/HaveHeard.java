package story.activity;

public final class HaveHeard extends Activity {
    public HaveHeard(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) {
        result += "услышал";

        return result;
    }
}
