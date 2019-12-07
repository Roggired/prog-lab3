package story.activity;

public final class Place extends Activity {
    public Place(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) {
        result += "расположилось";

        return result;
    }
}
