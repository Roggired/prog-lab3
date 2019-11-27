package story.activity;

import story.activity.exception.ActivityException;

public class Agreed extends Activity {
    public static final String NAME = "условиться";

    private final String OBJECT_REQUIRED_FEATURE = "с этим можно условиться";


    @Override
    public String getName() {
        return NAME;
    }

    @Override
    protected String appendExecutionResult(String result) throws ActivityException {
        checkObjectRequiredFeature(OBJECT_REQUIRED_FEATURE);

        result += " условился с " + environments[0].getName();

        return result;
    }
}
