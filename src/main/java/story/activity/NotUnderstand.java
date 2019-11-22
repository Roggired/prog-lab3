package story.activity;

public final class NotUnderstand extends Activity{
    public static final String NAME = "не понять";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    protected String appendExecutionResult(String result) {
        result += "не понял";

        return result;
    }
}
