package environment;

import characteristic.Characteristic;
import environment.feature.Feature;

import javax.lang.model.element.Name;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Environment {
    private String name;
    private List<Environment> environmentalObjects = new ArrayList<>();
    private List<Feature> features = new ArrayList<>();
    private List<Characteristic> characteristics = new ArrayList<>();


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


    public void addCharacteristic(Characteristic characteristic) {
        if (characteristics == null) {
            characteristics = new ArrayList<>();
        }
        characteristics.add(characteristic);
    }
    public boolean haveFeature(String featureName) {
        for (Feature feature : features) {
            if (feature.getName().equals(featureName)) {
                return  true;
            }
        }

        return false;
    }


    public void printInfo(PrintStream printStream) {
        StringBuilder stringBuilder = new StringBuilder(name);
        stringBuilder.append("\n");
        stringBuilder.append("Включает в себя: ");
        environmentalObjects.forEach(environment -> stringBuilder.append(environment.getName()));
        stringBuilder.append("\n");
        stringBuilder.append("Имеет фичи: ");
        features.forEach(feature -> stringBuilder.append(feature.getName()));
        stringBuilder.append("\n");
        stringBuilder.append("Имеет характеристики: ");
        characteristics.forEach(characteristic -> stringBuilder.append(characteristic.getName()));

        printStream.println(stringBuilder.toString());
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
