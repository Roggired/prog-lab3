package story.activity;

import story.activity.annotations.WithSingleObject;
import story.activity.exception.NoFeatureException;

@WithSingleObject
public final class Notice extends Activity {
    private String objectRequiredFeature = "это можно заметить";


    public Notice(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) throws NoFeatureException {
        checkObjectRequiredFeature(objectRequiredFeature, environments);

        result += "заметил " + environments[0].getName();

        return result;
    }
}
