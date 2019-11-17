package story.environment.factory;

import story.environment.Environment;
import story.environment.feature.Feature;

import java.util.List;

public interface IEnvironmentFactory {
    Environment create(String name, List<Feature> features);
}
