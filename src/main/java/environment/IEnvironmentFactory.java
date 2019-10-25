package environment;

import environment.feature.Feature;

import java.util.List;

public interface IEnvironmentFactory {
    Environment create(String name, List<Feature> features);
}
