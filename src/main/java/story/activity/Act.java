package story.activity;

import story.activity.annotations.WithSingleObject;
import story.activity.exception.NoFeatureException;

@WithSingleObject
public final class Act extends Activity {
    private String objectRequiredFeature = "в этом можно так поступать";


    public Act(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) throws NoFeatureException {
        checkObjectRequiredFeature(objectRequiredFeature, environments);

        result += "поступают в " + environments[0].getName();

        return result;
    }
}
