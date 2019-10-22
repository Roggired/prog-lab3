package activity;

import pokemon.Pokemon;

public interface IActivity {
    String getName();

    void executeFor(Pokemon pokemon);
}
