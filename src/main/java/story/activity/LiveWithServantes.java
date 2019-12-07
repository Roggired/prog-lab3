package story.activity;

public final class LiveWithServantes extends Activity{
    public LiveWithServantes(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) {
        result += "живет у Сервантесов";

        return result;
    }
}
