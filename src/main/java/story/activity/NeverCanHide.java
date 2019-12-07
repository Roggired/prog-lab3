package story.activity;

public final class NeverCanHide extends Activity {
    public NeverCanHide(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) {
        result += "никогда не умел прятаться";

        return result;
    }
}
