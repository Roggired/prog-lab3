package story.activity;

import story.environment.Environment;
import story.pokemon.Pokemon;

public final class NotUnderstand extends Activity{
    public static final String NAME = "не понять";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String executeFor(Pokemon pokemon,
                             Environment... environments) {
        if (environments.length >  0) {
            return pokemon.getName() + " "
                    + characteristic.getName()
                    + " не понял " + environments[0].getName();
        }

        return pokemon.getName() + " "
                + characteristic.getName() + " не понял";
    }
}
