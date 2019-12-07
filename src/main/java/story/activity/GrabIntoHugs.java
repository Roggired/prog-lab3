package story.activity;

import story.activity.annotations.WithSingleObject;
import story.activity.exception.ActivityException;
import story.activity.exception.NoFeatureException;

@WithSingleObject
public final class GrabIntoHugs extends Activity {
    private String objectRequiredFeature = "это можно сгрести в охапку";


    public GrabIntoHugs(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) throws NoFeatureException {
        checkObjectRequiredFeature(objectRequiredFeature, environments);

        result += "сгреб в охапку " + environments[0].getName();

        return result;
    }
}
