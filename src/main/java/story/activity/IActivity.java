package story.activity;

import story.activity.exception.ActivityException;
import story.environment.Environment;
import story.pokemon.Pokemon;

public interface IActivity {
    String getName();

    String executeFor(Pokemon pokemon,
                      Environment ...environments) throws ActivityException;
}
