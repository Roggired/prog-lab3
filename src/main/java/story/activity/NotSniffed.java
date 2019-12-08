package story.activity;

import story.activity.annotations.WithSingleObject;
import story.activity.exception.NoFeatureException;

@WithSingleObject
public final class NotSniffed extends Activity {
    private String objectRequiredFeature = "об этом можно не пронюхать";


    public NotSniffed(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) throws NoFeatureException {
        checkObjectRequiredFeature(objectRequiredFeature, environments);

        result += "не пронюхали про " + environments[0].getName();

        return result;
    }
}