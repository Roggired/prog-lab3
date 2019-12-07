package story.activity;

public final class Bore extends Activity {
    public static final String NAME = "скучать";


    public Bore(String name, String... requirements) {
        super(name, requirements);
    }


    @Override
    protected String appendExecutionResult(String result) {
        result += "заскучал";

        return result;
    }
}
