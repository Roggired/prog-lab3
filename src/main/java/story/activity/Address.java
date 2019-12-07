package story.activity;

import story.activity.annotations.WithSingleObject;
import story.activity.exception.NoFeatureException;

@WithSingleObject
public final class Address extends Activity {
    private String objectRequiredFeature = "к этому можно обратиться";


    public Address(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) throws NoFeatureException {
        checkObjectRequiredFeature(objectRequiredFeature, environments);

        result += "обращался к " + environments[0].getName();

        return result;
    }
}
