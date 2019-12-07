package story.activity;

import story.activity.annotations.WithTwoObject;
import story.activity.exception.ActivityException;
import story.activity.exception.NoFeatureException;

@WithTwoObject
public final class MeetOther extends Activity {
    private String objectRequiredFeature = "это можно встретить";
    private String containerRequiredFeature = "здесь это можно встретить";


    public MeetOther(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) throws NoFeatureException {
        checkObjectRequiredFeature(objectRequiredFeature, environments);
        checkContainerRequiredFeature(containerRequiredFeature, environments);

        result += "встречал " + environments[0].getName() + " в " + environments[1].getName();

        return result;
    }
}
