package story.activity;

import story.activity.annotations.WithSingleObject;
import story.activity.exception.NoFeatureException;

@WithSingleObject
public final class HaveSit extends Activity {
    private String objectRequiredFeature = "на это можно сесть";


    public HaveSit(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) throws NoFeatureException {
        checkObjectRequiredFeature(objectRequiredFeature, environments);

        result += "сел на " + environments[0].getName();

        return result;
    }
}
