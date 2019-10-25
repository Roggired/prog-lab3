package pokemon.factory;

import activity.IActivity;
import characteristic.Characteristic;
import pokemon.Pokemon;

import java.util.List;

public interface IPokemonFactory {
    Pokemon create(String name, List<Characteristic> characteristics, List<IActivity> activities);
}
