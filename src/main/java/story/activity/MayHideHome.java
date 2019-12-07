package story.activity;

public final class MayHideHome extends Activity {
    public MayHideHome(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) {
        result += "может спрятаться у себя дома";

        return result;
    }
}
