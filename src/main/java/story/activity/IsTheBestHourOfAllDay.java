package story.activity;

import story.activity.annotations.WithoutSubject;

@WithoutSubject
public final class IsTheBestHourOfAllDay extends Activity{
    public IsTheBestHourOfAllDay(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) {
        result += "это был самый веселый час за весь день";

        return result;
    }
}
