package story.activity;

import story.activity.annotations.WithTwoObject;
import story.activity.exception.ActivityException;
import story.activity.exception.NoFeatureException;

@WithTwoObject
public final class Play extends Activity {
    private String objectRequiredFeature = "с этим можно играть";
    private String containerRequiredFeature = "здесь можно играть";


    public Play(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) throws NoFeatureException {
        checkObjectRequiredFeature(objectRequiredFeature, environments);
        checkContainerRequiredFeature(containerRequiredFeature, environments);

        result += "играл с " + environments[0].getName() + " в " + environments[1].getName();

        return result;
    }
}
