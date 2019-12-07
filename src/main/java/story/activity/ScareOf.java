package story.activity;

public final class ScareOf extends Activity {
    public ScareOf(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) {
        result += "чего бояться?";

        return result;
    }
}
