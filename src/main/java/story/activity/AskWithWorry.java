package story.activity;

public final class AskWithWorry extends Activity{
    public AskWithWorry(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) {
        result += "спросил с тревогой";

        return result;
    }
}
