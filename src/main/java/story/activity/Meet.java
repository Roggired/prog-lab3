package story.activity;

import story.environment.Environment;
import story.pokemon.Pokemon;

public class Meet extends Activity {
    public static final String NAME = "встречаться";


    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String executeFor(Pokemon pokemon,
                             Environment... environments) {
        return pokemon.getName() + " "
                + characteristic.getName()
                + " встречаться";
    }
}
