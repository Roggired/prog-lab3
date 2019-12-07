package story.activity;


public final class OpenEyes extends Activity{
    public static final String NAME = "раскрыть глаза";


    public OpenEyes(String name, String... requirements) {
        super(name, requirements);
    }


    @Override
    protected String appendExecutionResult(String result) {
        result += "открыл глаза";

        return result;
    }
}
