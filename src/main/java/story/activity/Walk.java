package story.activity;

import story.activity.annotations.WithTwoObject;
import story.activity.exception.ActivityException;
import story.activity.exception.NoFeatureException;

@WithTwoObject
public final class Walk extends Activity {
    private String objectRequiredFeature = "с этим можно гулять";
    private String containerRequiredFeature = "здесь можно гулять";


    public Walk(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) throws NoFeatureException {
        checkObjectRequiredFeature(objectRequiredFeature, environments);
        checkContainerRequiredFeature(containerRequiredFeature, environments);

        result += "гулял с " + environments[0].getName() + " в " + environments[1].getName();

        return result;
    }
}