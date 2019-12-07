package story.activity;

public final class WantToRushIntoBattle extends Activity {
    public WantToRushIntoBattle(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) {
        result += "хотел было ринуться в бой";

        return result;
    }
}
