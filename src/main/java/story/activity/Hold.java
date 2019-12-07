package story.activity;

import story.activity.annotations.WithTwoObject;
import story.activity.annotations.WithoutSubject;
import story.activity.exception.ActivityException;
import story.activity.exception.NoFeatureException;

@WithoutSubject
@WithTwoObject
public final class Hold extends Activity {
    private String objectRequiredFeature = "это можно держать";
    private String containerRequiredFeature = "в этом можно держать";


    public Hold(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) throws NoFeatureException {
        checkObjectRequiredFeature(objectRequiredFeature, environments);
        checkContainerRequiredFeature(containerRequiredFeature, environments);

        result += "держал в " + environments[1].getName() + " " + environments[0].getName();

        return result;
    }
}
