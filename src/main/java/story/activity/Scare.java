package story.activity;

public final class Scare extends Activity {
    public Scare(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) {
        result += "испугался";

        return result;
    }
}
