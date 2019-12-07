package story.activity;

import story.activity.annotations.WithSingleObject;
import story.activity.exception.ActivityException;
import story.activity.exception.NoFeatureException;

@WithSingleObject
public final class GoOver extends Activity {
    public static final String NAME = "перемахнуть";

    private String objectRequiredFeature = "можно перемахнуть";


    public GoOver(String name, String... requirements) {
        super(name, requirements);

        //objectRequiredFeature = requirements[0];
    }


    @Override
    protected String appendExecutionResult(String result) throws NoFeatureException {
        checkObjectRequiredFeature(objectRequiredFeature, environments);

        result += "перемахнул через " + environments[0].getName();

        return result;
    }
}
