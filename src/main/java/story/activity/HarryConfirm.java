package story.activity;

public final class HarryConfirm extends Activity {
    public static final String NAME = "поспешить подтвердить";


    public HarryConfirm(String name, String... requirements) {
        super(name, requirements);
    }


    @Override
    protected String appendExecutionResult(String result) {
        result += "поспешил подтвердить";

        return result;
    }
}
