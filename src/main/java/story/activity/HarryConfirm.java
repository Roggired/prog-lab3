package story.activity;

public class HarryConfirm extends Activity {
    public static final String NAME = "поспешить подтвердить";


    @Override
    public String getName() {
        return NAME;
    }

    @Override
    protected String appendExecutionResult(String result) {
        result += "поспешил подтвердить";

        return result;
    }
}
