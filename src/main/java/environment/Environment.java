package environment;

import environment.feature.Feature;

import java.util.List;

public class Environment {
    private String name;
    private List<Environment> environmentalObjects;
    private List<Feature> features;


    public Environment(String name) {
        this.name = name;
    }

    public Environment(String name, List<Feature> features) {
        this.name = name;
        this.features = features;
    }

    public Environment(String name,
                       List<Environment> environmentalObjects,
                       List<Feature> features) {
        this.name = name;
        this.environmentalObjects = environmentalObjects;
        this.features = features;
    }


    public boolean haveFeature(String featureName) {
        for (Feature feature : features) {
            if (feature.getName().equals(featureName)) {
                return  true;
            }
        }

        return false;
    }


    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getClass().toString() + " name: " + name;
    }

    @Override
    public boolean equals(Object object) {
        return super.equals(object);
        //TODO: реализовать рекурсивную проверку на равенство
    }

    @Override
    public int hashCode() {
        return 1;
        //TODO: реализовать хешкоды
    }
}
