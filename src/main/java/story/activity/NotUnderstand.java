package story.activity;

public final class NotUnderstand extends Activity{
    public static final String NAME = "не понять";


    public NotUnderstand(String name, String... requirements) {
        super(name, requirements);
    }


    @Override
    protected String appendExecutionResult(String result) {
        result += "не понял";

        return result;
    }
}
