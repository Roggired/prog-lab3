package story.activity;

import story.activity.annotations.WithSingleObject;
import story.activity.annotations.WithoutSubject;
import story.activity.exception.ActivityException;
import story.activity.exception.NoFeatureException;

@WithoutSubject
@WithSingleObject
public final class Show extends Activity {
    private String objectRequiredFeature = "этому можно показать";


    public Show(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) throws NoFeatureException {
        checkObjectRequiredFeature(objectRequiredFeature, environments);

        result += "показать " + environments[0].getName();

        return result;
    }
}
