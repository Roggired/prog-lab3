package story.activity;

import story.activity.annotations.WithTwoObject;
import story.activity.exception.ActivityException;
import story.activity.exception.NoFeatureException;

@WithTwoObject
public final class Discover extends Activity {
    private String objectRequiredFeature = "это можно обнаружить";
    private String containerRequiredFeature = "здесь это можно обнаружить";


    public Discover(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) throws NoFeatureException {
        checkObjectRequiredFeature(objectRequiredFeature, environments);
        checkContainerRequiredFeature(containerRequiredFeature, environments);

        result += "обнаружил " + environments[0].getName() + " " + environments[1].getName();

        return result;
    }
}
