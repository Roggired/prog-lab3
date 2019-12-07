package story.activity;

import java.util.Arrays;

public final class See extends Activity {
    public static final String NAME = "увидеть";


    public See(String name, String... requirements) {
        super(name, requirements);
    }


    @Override
    protected String appendExecutionResult(String result) {
        if (environments.length == 0) {
            result += "ничего не увидел";
        }

        StringBuilder stringBuilder = new StringBuilder("увидел: ");
        Arrays.asList(environments).forEach(environment -> stringBuilder.append(environment.getName()).append(" "));

        result += stringBuilder.toString().trim();

        return result;
    }
}
