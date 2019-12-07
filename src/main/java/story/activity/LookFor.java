package story.activity;

import story.activity.annotations.WithSingleObject;
import story.activity.exception.ActivityException;
import story.activity.exception.NoFeatureException;

@WithSingleObject
public final class LookFor extends Activity{
    private String objectRequiredFeature = "это можно поискать глазами";


    public LookFor(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) throws NoFeatureException {
        checkObjectRequiredFeature(objectRequiredFeature, environments);

        result += "поискал глазами " + environments[0].getName();

        return result;
    }
}
