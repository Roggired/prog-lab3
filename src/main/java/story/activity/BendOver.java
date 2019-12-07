package story.activity;

import story.activity.annotations.WithSingleObject;
import story.activity.exception.ActivityException;
import story.activity.exception.NoFeatureException;

@WithSingleObject
public final class BendOver extends Activity {
    public static final String NAME = "наклониться";

    private String objectRequiredFeature = "к этому можно наклониться";


    public BendOver(String name, String... requirements) {
        super(name, requirements);

        //objectRequiredFeature = requirements[0];
    }


    @Override
    protected String appendExecutionResult(String result) throws NoFeatureException {
        checkObjectRequiredFeature(objectRequiredFeature, environments);

        result += "наклонился к " + environments[0].getName();

        return result;
    }
}
