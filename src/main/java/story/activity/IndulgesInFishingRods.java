package story.activity;

public final class IndulgesInFishingRods extends Activity{
    public IndulgesInFishingRods(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) {
        result += "придется сматывать удочки";

        return result;
    }
}
