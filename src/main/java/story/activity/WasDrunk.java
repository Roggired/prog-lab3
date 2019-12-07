package story.activity;

public final class WasDrunk extends Activity {
    public WasDrunk(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result)  {
        result += "было выпито";

        return result;
    }
}
