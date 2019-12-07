package story.creator;

import story.environment.Environment;
import story.pokemon.Pokemon;

public interface Creator {
    Pokemon createPokemon(Integer id);

    Environment createEnvironment(Integer id);
}
