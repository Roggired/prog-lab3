package story.activity;


public final class OpenEyes extends Activity{
    public static final String NAME = "раскрыть глаза";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    protected String appendExecutionResult(String result) {
        result += "открыл глаза";

        return result;
    }
}