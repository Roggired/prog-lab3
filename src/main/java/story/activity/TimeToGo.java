package story.activity;


public final class TimeToGo extends Activity {
    public static final String NAME = "пора было уходить";


    public TimeToGo(String name, String... requirements) {
        super(name, requirements);
    }


    @Override
    protected String appendExecutionResult(String result) {
        result += "пора было уходить";

        return result;
    }
}
