package story.activity;

public class Be extends Activity {
    public static final String NAME = "бывать";


    @Override
    public String getName() {
        return NAME;
    }

    @Override
    protected String appendExecutionResult(String result) {
        result += "бываeт";

        return result;
    }
}
