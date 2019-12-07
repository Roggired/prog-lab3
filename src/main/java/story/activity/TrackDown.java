package story.activity;

import story.activity.annotations.WithSingleObject;
import story.activity.annotations.WithoutSubject;
import story.activity.exception.NoFeatureException;

@WithoutSubject
@WithSingleObject
public final class TrackDown extends Activity{
    private String objectRequiredFeature = "это можно выслеживать";


    public TrackDown(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) throws NoFeatureException {
        checkObjectRequiredFeature(objectRequiredFeature, environments);

        result += "выслеживают " + environments[0].getName();

        return result;
    }
}
