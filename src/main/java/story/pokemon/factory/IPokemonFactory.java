package story.pokemon.factory;

import story.activity.IActivity;
import story.characteristic.Characteristic;
import story.pokemon.Pokemon;

import java.util.List;

public interface IPokemonFactory {
    Pokemon create(String name, List<Characteristic> characteristics, List<IActivity> activities);
}
