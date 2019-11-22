package story.activity;

import story.activity.annotations.WithSingleObject;
import story.environment.Environment;
import story.pokemon.Pokemon;

@WithSingleObject
public final class NotNotice extends Activity {
    public static final String NAME = "не замечать";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String executeFor(Pokemon pokemon,
                             Environment... environments) {

        return pokemon.getName() + " "
                + characteristic.getName() +
                " не заметил " + environments[0].getName();
    }
}
