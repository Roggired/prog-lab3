package story.activity;

public final class DrinkBear extends Activity {
    public DrinkBear(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) {
        result += "пил пиво";

        return result;
    }
}
