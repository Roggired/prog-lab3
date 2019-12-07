package story.activity;

import story.activity.annotations.WithoutSubject;
import story.activity.exception.NoFeatureException;

@WithoutSubject
public final class SitNotAlong extends Activity{
    private String objectRequiredFeature = "здесь можно быть не одним";


    public SitNotAlong(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) throws NoFeatureException {
        checkObjectRequiredFeature(objectRequiredFeature, environments);

        result += "сидят не одни на " + environments[0].getName();

        return result;
    }
}
