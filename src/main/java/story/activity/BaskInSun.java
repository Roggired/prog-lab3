package story.activity;

public final class BaskInSun extends Activity{
    public BaskInSun(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) {
        result += "грелись на солнышке";

        return result;
    }
}
