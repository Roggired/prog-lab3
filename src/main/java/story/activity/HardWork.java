package story.activity;


public final class HardWork extends Activity{
    public HardWork(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) {
        result += "старался изо всех сил";

        return result;
    }
}
