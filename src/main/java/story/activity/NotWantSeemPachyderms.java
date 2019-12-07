package story.activity;

public final class NotWantSeemPachyderms extends Activity {
    public static final String NAME = "не хотеть показаться толстокожим";


    public NotWantSeemPachyderms(String name, String... requirements) {
        super(name, requirements);
    }


    @Override
    protected String appendExecutionResult(String result) {
        result += "не хотел показаться толстокожим";

        return result;
    }
}
