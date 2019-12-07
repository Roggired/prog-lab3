package story.activity;

import story.activity.annotations.WithoutSubject;

@WithoutSubject
public final class WillTalkAboutIt extends Activity{
    public WillTalkAboutIt(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) {
        result += "будут говорить об этом";

        return result;
    }
}
