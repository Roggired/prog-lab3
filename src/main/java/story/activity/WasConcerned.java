package story.activity;

public final class WasConcerned extends Activity {
    public WasConcerned(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) {
        result += "был озабочен";

        return result;
    }
}
