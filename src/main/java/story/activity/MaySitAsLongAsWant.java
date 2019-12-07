package story.activity;


public final class MaySitAsLongAsWant extends Activity {
    public MaySitAsLongAsWant(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) {
        result += "может сидеть с ними рядом сколько ему захочется";

        return result;
    }
}
