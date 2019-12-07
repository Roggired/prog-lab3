package story.activity;

public final class WillNotFindOut extends Activity{
    public WillNotFindOut(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) {
        result += "ничего не удастся выведать";

        return result;
    }
}
