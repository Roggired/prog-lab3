package story.activity;

public final class Sit extends Activity {
    public Sit(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) {
        result += "посидеть";

        return result;
    }
}
