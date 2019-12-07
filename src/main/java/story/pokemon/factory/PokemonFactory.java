package story.pokemon.factory;

import story.activity.Activity;
import story.characteristic.Characteristic;
import story.environment.feature.Feature;
import story.pokemon.Pokemon;

import java.util.List;

public interface PokemonFactory {
    Pokemon create(String name,
                   List<Characteristic> characteristics,
                   List<Activity> activities,
                   List<Feature> features);
}
