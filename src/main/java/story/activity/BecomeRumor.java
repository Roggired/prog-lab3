package story.activity;

public final class BecomeRumor extends Activity {
    public BecomeRumor(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) {
        result += "весь превратился в слух";

        return result;
    }
}
