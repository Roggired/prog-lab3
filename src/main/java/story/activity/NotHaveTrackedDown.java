package story.activity;

import story.activity.annotations.WithSingleObject;
import story.activity.exception.NoFeatureException;

@WithSingleObject
public final class NotHaveTrackedDown extends Activity{
    private String objectRequiredFeature = "это можно не выследить";


    public NotHaveTrackedDown(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) throws NoFeatureException {
        checkObjectRequiredFeature(objectRequiredFeature, environments);

        result += "не выследил " + environments[0].getName();

        return result;
    }
}
