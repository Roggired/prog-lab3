package story.activity;

import story.activity.annotations.WithSingleObject;
import story.activity.exception.ActivityException;
import story.activity.exception.NoFeatureException;

@WithSingleObject
public final class Hunt extends Activity {
    private String objectRequiredFeature = "за этим можно охотиться";


    public Hunt(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) throws NoFeatureException {
        checkObjectRequiredFeature(objectRequiredFeature, environments);

        result += "продолжает ли охотиться за " + environments[0].getName();

        return result;
    }
}
