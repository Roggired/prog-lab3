package story.activity;


public final class Meet extends Activity {
    public static final String NAME = "встречаться";


    public Meet(String name, String... requirements) {
        super(name, requirements);
    }


    @Override
    protected String appendExecutionResult(String result)  {
        result += "встречаться";

        return result;
    }
}
