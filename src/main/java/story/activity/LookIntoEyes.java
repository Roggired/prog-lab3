package story.activity;

import story.activity.annotations.WithSingleObject;
import story.activity.exception.ActivityException;
import story.activity.exception.NoFeatureException;

@WithSingleObject
public final class LookIntoEyes extends Activity {
    public static final String NAME = "заглянуться в глаза";

    private String objectRequiredFeature = "этому можно заглянуть в глаза";


    public LookIntoEyes(String name, String... requirements) {
        super(name, requirements);

        //objectRequiredFeature = requirements[0];
    }


    @Override
    protected String appendExecutionResult(String result) throws NoFeatureException {
        checkObjectRequiredFeature(objectRequiredFeature, environments);

        result += "заглянул в глаза " + environments[0].getName();

        return result;
    }
}
