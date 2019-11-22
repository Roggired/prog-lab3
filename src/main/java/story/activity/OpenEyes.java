package story.activity;

import story.activity.exception.ActivityException;
import story.environment.Environment;
import story.pokemon.Pokemon;

public final class OpenEyes extends Activity{
    public static final String NAME = "раскрыть глаза";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String executeFor(Pokemon pokemon,
                             Environment... environments) {
        return pokemon.getName() + " "
                + characteristic.getName()
                + " открыл глаза";
    }
}
