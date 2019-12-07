package story.activity;

public final class Believe extends Activity {
    public Believe(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) {
        result += "считал";

        return result;
    }
}
