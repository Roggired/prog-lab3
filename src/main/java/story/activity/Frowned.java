package story.activity;


public final class Frowned extends Activity {
    public Frowned(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) {
        result += "нахмурил брови";

        return result;
    }
}
