package story.activity;

public class NotWantSeemPachyderms extends Activity {
    public static final String NAME = "не хотеть показаться толстокожим";


    @Override
    public String getName() {
        return NAME;
    }

    @Override
    protected String appendExecutionResult(String result) {
        result += "не хотел показаться толстокожим";

        return result;
    }
}
