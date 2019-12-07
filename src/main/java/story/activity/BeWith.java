package story.activity;

import story.activity.annotations.WithSingleObject;
import story.activity.annotations.WithoutSubject;
import story.activity.exception.ActivityException;
import story.activity.exception.NoFeatureException;

@WithoutSubject
@WithSingleObject
public final class BeWith extends Activity{
    private String objectRequiredFeature = "это может быть с покемоном";


    public BeWith(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) throws NoFeatureException {
        checkObjectRequiredFeature(objectRequiredFeature, environments);

        result += "у " + pokemon.getName() + " есть " + environments[0].getName();

        return result;
    }
}
