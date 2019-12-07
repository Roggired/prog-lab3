package story.activity;

import story.activity.annotations.WithSingleObject;
import story.activity.exception.ActivityException;
import story.activity.exception.NoFeatureException;

@WithSingleObject
public final class NeverSee extends Activity {
    private String objectRequiredFeature = "это можно никогда не видеть";


    public NeverSee(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) throws NoFeatureException {
        checkObjectRequiredFeature(objectRequiredFeature, environments);

        result += "никогда не замечал " + environments[0].getName();

        return result;
    }
}
