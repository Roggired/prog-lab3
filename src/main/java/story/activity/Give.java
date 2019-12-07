package story.activity;

import story.activity.annotations.WithTwoObject;
import story.activity.exception.ActivityException;
import story.activity.exception.NoFeatureException;

@WithTwoObject
public final class Give extends Activity {
    private String objectRequiredFeature = "это можно подать";
    private String containerRequiredFeature = "этому можно подать";


    public Give(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) throws NoFeatureException {
        checkObjectRequiredFeature(objectRequiredFeature, environments);
        checkContainerRequiredFeature(containerRequiredFeature, environments);

        result += "подал " + environments[0].getName() + " " + environments[1].getName();

        return result;
    }
}
