package story.activity;

import story.activity.exception.ActivityException;
import story.environment.Environment;
import story.pokemon.Pokemon;

public class NotWantSeemPachyderms extends Activity {
    public static final String NAME = "не хотеть показаться толстокожим";


    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String executeFor(Pokemon pokemon,
                             Environment... environments) {
        return pokemon.getName() + " "
                + characteristic.getName()
                + " не хотел показаться толстокожим";
    }
}
