package environment;

import characteristic.Characteristic;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;
import environment.feature.Feature;

import java.util.ArrayList;
import java.util.List;

public class Environment {
    @JsonProperty
    private String name;

    @JsonProperty
    private List<Feature> features;

    private List<Characteristic> characteristics = new ArrayList<>();


    public Environment() {}

    @AssistedInject
    public Environment(@Assisted String name, @Assisted List<Feature> features) {
        this.name = name;
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


    public String getName() {
        return name;
    }
    public String getNameWithCharacteristics() {
        if (characteristics != null && !characteristics.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            characteristics.forEach(characteristic -> stringBuilder.append(characteristic.getName()).append(" "));

            return stringBuilder.toString() + name;
        }

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
