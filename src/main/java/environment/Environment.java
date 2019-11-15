package environment;

import characteristic.Characteristic;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;
import environment.feature.Feature;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Environment {
    @JsonProperty
    private String name;

    @JsonProperty
    private List<Feature> features;

    private List<Characteristic> characteristics = new ArrayList<>();


    public Environment() {}

    @AssistedInject
    public Environment(@Assisted String name,
                       @Assisted List<Feature> features) {
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
        return getClass().toString() + name + features.toString() + characteristics.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (!Objects.equals(this, object)) {
            return false;
        }

        if (!name.equals(((Environment) object).name)) {
            return false;
        }

        Environment environment = (Environment) object;

        class ListContainsDeterminant<T> {
            private boolean isEqualList(List<T> listA, List<T> listB) {
                for (T objectA : listA) {
                    boolean isContained = false;

                    for (T objectB : listB) {
                        if (objectA.equals(objectB)) {
                            isContained = true;
                            break;
                        }
                    }

                    if (!isContained) {
                        return false;
                    }
                }

                return true;
            }
        }

        ListContainsDeterminant<Feature> featuresDeterminant = new ListContainsDeterminant<>();

        if (!featuresDeterminant.isEqualList(features, environment.features)) {
            return false;
        }

        ListContainsDeterminant<Characteristic> characteristicsDeterminant = new ListContainsDeterminant<>();

        if (!characteristicsDeterminant.isEqualList(characteristics, environment.characteristics)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + features.hashCode() + characteristics.hashCode();
    }
}
