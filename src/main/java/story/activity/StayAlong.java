package story.activity;

public class StayAlong extends Activity {
    public static final String NAME = "остаться одному";


    @Override
    public String getName() {
        return NAME;
    }

    @Override
    protected String appendExecutionResult(String result) {
        result += "остался один";

        return result;
    }
}
