package story.activity;

import story.activity.annotations.WithTwoObject;
import story.activity.exception.ActivityException;
import story.activity.exception.NoFeatureException;

@WithTwoObject
public final class AttachTo extends Activity {
    public static final String NAME = "прикрепить к";

    private String objectRequiredFeature = "это можно прикрепить";
    private String containerRequiredFeature = "к этому можно прикрепить";


    public AttachTo(String name, String... requirements) {
        super(name, requirements);

        //objectRequiredFeature = requirements[0];
        //containerRequiredFeature = requirements[1];
    }


    @Override
    protected String appendExecutionResult(String result) throws NoFeatureException {
        checkObjectRequiredFeature(objectRequiredFeature, environments);
        checkContainerRequiredFeature(containerRequiredFeature, environments);

        result += " прикрепил " + environments[0].getName() + " к " + environments[1].getName();

        return result;
    }
}
