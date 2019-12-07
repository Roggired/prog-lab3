package story.activity;

import story.activity.annotations.WithSingleObject;
import story.activity.exception.NoFeatureException;

@WithSingleObject
public final class HaveInterest extends Activity {
    private String objectRequiredFeature = "этим можно интересоваться";


    public HaveInterest(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) throws NoFeatureException {
        checkObjectRequiredFeature(objectRequiredFeature, environments);

        result += "интересуется " + environments[0].getName();

        return result;
    }
}
