package story.activity;

public class Bore extends Activity {
    public static final String NAME = "скучать";


    @Override
    public String getName() {
        return NAME;
    }

    @Override
    protected String appendExecutionResult(String result) {
        result += "заскучал";

        return result;
    }
}
