package story.activity;

public final class CalmDown extends Activity{
    public CalmDown(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) {
        result += "успокоиться";

        return result;
    }
}
