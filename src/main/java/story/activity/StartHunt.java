package story.activity;

import story.activity.annotations.WithoutSubject;
import story.activity.exception.NoFeatureException;

@WithoutSubject
public final class StartHunt extends Activity {
    private String objectRequiredFeature = "за этим можно начать охоту";


    public StartHunt(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) throws NoFeatureException {
        checkObjectRequiredFeature(objectRequiredFeature, environments);

        result += "начнется охота за " + environments[0].getName();

        return result;
    }
}
