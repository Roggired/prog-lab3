package story.activity;

public final class StayAlong extends Activity {
    public static final String NAME = "остаться одному";


    public StayAlong(String name, String... requirements) {
        super(name, requirements);
    }


    @Override
    protected String appendExecutionResult(String result) {
        result += "остался один";

        return result;
    }
}
