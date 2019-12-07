package story.activity;

import story.activity.annotations.WithSingleObject;
import story.activity.exception.ActivityException;
import story.activity.exception.NoFeatureException;

@WithSingleObject
public final class Wandered extends Activity {
    private String objectRequiredFeature = "сюда можно забрести";


    public Wandered(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) throws NoFeatureException {
        checkObjectRequiredFeature(objectRequiredFeature, environments);

        result += "забрел в " + environments[0].getName();

        return result;
    }
}
