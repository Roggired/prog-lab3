package story.activity;

import story.activity.annotations.WithSingleObject;
import story.activity.exception.ActivityException;
import story.activity.exception.NoFeatureException;

@WithSingleObject
public final class HaveToAbort extends Activity {
    public static final String NAME = "пришлось прервать";

    private String objectRequiredFeature = "это можно прервать";


    public HaveToAbort(String name, String... requirements) {
        super(name, requirements);

        //objectRequiredFeature = requirements[0];
    }


    @Override
    protected String appendExecutionResult(String result) throws NoFeatureException {
        checkObjectRequiredFeature(objectRequiredFeature, environments);

        result += "пришлось прервать" + " " + environments[0].getName();

        return result;
    }
}
