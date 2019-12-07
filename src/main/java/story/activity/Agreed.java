package story.activity;

import story.activity.annotations.WithSingleObject;
import story.activity.exception.ActivityException;
import story.activity.exception.NoFeatureException;

@WithSingleObject
public final class Agreed extends Activity {
    public static final String NAME = "условиться";

    private String objectRequiredFeature = "с этим можно условиться";


    public Agreed(String name,
                  String... requirements) {
        super(name, requirements);

        //objectRequiredFeature = requirements[0];
    }


    @Override
    protected String appendExecutionResult(String result) throws NoFeatureException {
        checkObjectRequiredFeature(objectRequiredFeature, environments);

        result += "условился с " + environments[0].getName();

        return result;
    }
}
