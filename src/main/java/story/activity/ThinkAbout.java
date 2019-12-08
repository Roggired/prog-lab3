package story.activity;

import story.activity.annotations.WithSingleObject;

@WithSingleObject
public final class ThinkAbout extends Activity {
    public static final String NAME = "думать";


    public ThinkAbout(String name, String... requirements) {
        super(name, requirements);
    }


    @Override
    protected String appendExecutionResult(String result) {
        result += "думал о " + environments[0].getName();

        return result;
    }
}
