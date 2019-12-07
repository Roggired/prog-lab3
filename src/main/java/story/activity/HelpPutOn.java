package story.activity;

import story.activity.annotations.WithTwoObject;
import story.activity.exception.ActivityException;
import story.activity.exception.NoFeatureException;

@WithTwoObject
public final class HelpPutOn extends Activity {
    private String objectRequiredFeature = "это можно помочь надеть";
    private String containerRequiredFeature = "этому можно помочь надеть";


    public HelpPutOn(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) throws NoFeatureException {
        checkObjectRequiredFeature(objectRequiredFeature, environments);
        checkContainerRequiredFeature(containerRequiredFeature, environments);

        result += "помог надеть " + environments[0].getName() + " " + environments[1].getName();

        return result;
    }
}
