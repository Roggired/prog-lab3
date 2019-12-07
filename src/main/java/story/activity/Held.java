package story.activity;

import story.activity.annotations.WithTwoObject;
import story.activity.exception.ActivityException;
import story.activity.exception.NoFeatureException;

@WithTwoObject
public final class Held extends Activity{
    private String objectRequiredFeature = "это можно проводить";
    private String containerRequiredFeature = "к этому можно проводить";


    public Held(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) throws NoFeatureException {
        checkObjectRequiredFeature(objectRequiredFeature, environments);
        checkContainerRequiredFeature(containerRequiredFeature, environments);

        result += "проводил " + environments[0].getName() + " до " + environments[1].getName();

        return result;
    }
}
