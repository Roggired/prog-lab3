package story.activity;

import story.activity.annotations.WithSingleObject;
import story.activity.annotations.WithoutSubject;
import story.activity.exception.NoFeatureException;

@WithoutSubject
@WithSingleObject
public final class DontKnow extends Activity {
    private String objectRequiredFeature = "это можно не знать";


    public DontKnow(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) throws NoFeatureException {
        checkObjectRequiredFeature(objectRequiredFeature, environments);

        result += "не знают " + environments[0].getName();

        return result;
    }
}
