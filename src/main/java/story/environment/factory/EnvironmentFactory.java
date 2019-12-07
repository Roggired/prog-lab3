package story.environment.factory;

import story.characteristic.Characteristic;
import story.environment.Environment;
import story.environment.feature.Feature;

import java.util.List;

public interface EnvironmentFactory {
    Environment create(String name, List<Characteristic> characteristics, List<Feature> features);
}
