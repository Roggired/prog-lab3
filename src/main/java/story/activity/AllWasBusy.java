package story.activity;

import story.activity.annotations.WithoutSubject;

@WithoutSubject
public final class AllWasBusy extends Activity {
    public AllWasBusy(String name, String... requirements) {
        super(name, requirements);
    }

    @Override
    protected String appendExecutionResult(String result) {
        result += "все было занято";

        return result;
    }
}
