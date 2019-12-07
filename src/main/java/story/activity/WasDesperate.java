package story.activity;

public final class WasDesperate extends Activity {
    public WasDesperate(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) {
        result += "был в отаянии";

        return result;
    }
}
