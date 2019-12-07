package story.activity;

public final class Be extends Activity {
    public static final String NAME = "бывать";


    public Be(String name, String... requirements) {
        super(name, requirements);
    }


    @Override
    protected String appendExecutionResult(String result) {
        result += "бываeт";

        return result;
    }
}
