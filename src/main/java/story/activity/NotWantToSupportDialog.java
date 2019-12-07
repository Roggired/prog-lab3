package story.activity;

import story.activity.annotations.WithSingleObject;
import story.activity.exception.ActivityException;
import story.activity.exception.NoFeatureException;

@WithSingleObject
public final class NotWantToSupportDialog extends Activity{
    private String objectRequiredFeature = "об этом можно поддерживать разговор";


    public NotWantToSupportDialog(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) throws NoFeatureException {
        checkObjectRequiredFeature(objectRequiredFeature, environments);

        result += "не был склонен поддерживать разговор о " + environments[0].getName();

        return result;
    }
}
