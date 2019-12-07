package story.activity;

public final class DontThink extends Activity{
    public DontThink(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) {
        result += "не думал";

        return result;
    }
}
