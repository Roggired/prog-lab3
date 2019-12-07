package story.activity;


public final class ReallyThink extends Activity {
    public ReallyThink(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) {
        result += "в самом деле думает";

        return result;
    }
}
