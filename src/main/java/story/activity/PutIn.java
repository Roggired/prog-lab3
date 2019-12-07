package story.activity;

import story.activity.annotations.WithTwoObject;
import story.activity.exception.ActivityException;
import story.activity.exception.NoFeatureException;

@WithTwoObject
public final class PutIn extends Activity {
    public static final String NAME = "положить в";
    private String objectRequiredFeature = "это можно положить";
    private String containerRequiredFeature = "в это можно положить";


    public PutIn(String name, String... requirements) {
        super(name, requirements);

        //objectRequiredFeature = requirements[0];
        //containerRequiredFeature = requirements[1];
    }


    @Override
    protected String appendExecutionResult(String result) throws NoFeatureException {
        checkObjectRequiredFeature(objectRequiredFeature, environments);
        checkContainerRequiredFeature(containerRequiredFeature, environments);

        result += "положил " + environments[0].getName() + " в " + environments[1].getName();

        return result;
    }
}
