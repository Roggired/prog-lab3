package story.activity;

import story.activity.exception.ActivityException;
import story.activity.exception.NoFeatureException;

public final class Eat extends Activity{
    public static final String NAME = "съели";

    private String objectRequiredFeature = "это можно съесть";


    public Eat(String name, String... requirements) {
        super(name, requirements);

        //objectRequiredFeature = requirements[0];
    }


    @Override
    protected String appendExecutionResult(String result) throws NoFeatureException {
        checkObjectRequiredFeature(objectRequiredFeature, environments);

        result += "съел " + environments[0].getName();

        return result;
    }
}
