package story.activity;

import story.activity.annotations.WithSingleObject;
import story.activity.exception.ActivityException;
import story.activity.exception.NoFeatureException;

@WithSingleObject
public final class Squeeze extends Activity {
    public static final String NAME = "сжать";

    private String objectRequiredFeature = "это можно сжать";


    public Squeeze(String name, String... requirements) {
        super(name, requirements);

        //objectRequiredFeature = requirements[0];
    }


    @Override
    protected String appendExecutionResult(String result) throws NoFeatureException {
        checkObjectRequiredFeature(objectRequiredFeature, environments);

        result += "сжал " + environments[0].getName();

        return result;
    }
}
