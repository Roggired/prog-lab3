package story.activity;

import story.activity.annotations.WithTwoObject;
import story.activity.exception.ActivityException;
import story.activity.exception.NoFeatureException;

@WithTwoObject
public final class Attract extends Activity {
    private String objectRequiredFeature = "это можно притягивать";
    private String containerRequiredFeature = "к этому можно притягивать";


    public Attract(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) throws NoFeatureException {
        checkObjectRequiredFeature(objectRequiredFeature, environments);
        checkContainerRequiredFeature(containerRequiredFeature, environments);

        result += "притягивало " + environments[0].getName() + " к " + environments[1].getName();

        return result;
    }
}
