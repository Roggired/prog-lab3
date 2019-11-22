package story.activity;

import story.environment.Environment;
import story.pokemon.Pokemon;

public class HarryConfirm extends Activity {
    public static final String NAME = "поспешить подтвердить";


    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String executeFor(Pokemon pokemon,
                             Environment... environments) {
        return pokemon.getName() + " "
                + characteristic.getName()
                + " поспешил подтвердить";
    }
}
