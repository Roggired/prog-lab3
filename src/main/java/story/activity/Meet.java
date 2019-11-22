package story.activity;


public class Meet extends Activity {
    public static final String NAME = "встречаться";


    @Override
    public String getName() {
        return NAME;
    }

    @Override
    protected String appendExecutionResult(String result)  {
        result += "встречаться";

        return result;
    }
}
