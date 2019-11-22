package story.pokemon;

import story.activity.*;
import story.activity.exception.*;
import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;
import story.characteristic.reason.IReasonProducer;
import story.environment.Environment;
import story.characteristic.Characteristic;
import story.environment.feature.Feature;
import story.pokemon.healthySense.HealthySense;

import java.util.List;

public class Pokemon extends Environment implements IReasonProducer {
    private String name;
    private List<Activity> activities;
    private List<Characteristic> characteristics;
    private HealthySense healthySense;


    @AssistedInject
    public Pokemon(@Assisted String name,
                   @Assisted List<Activity> activities,
                   @Assisted List<Characteristic> characteristics,
                   @Assisted List<Feature> features,
                   HealthySense healthySense) {
        super(name, features);
        this.name = name;
        this.characteristics = characteristics;
        this.activities = activities;
        this.healthySense = healthySense;
    }


    @Override
    public String getName() {
        if (characteristics != null && !characteristics.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            characteristics.forEach(characteristic -> stringBuilder.append(characteristic.getName()).append(" "));

            return stringBuilder.toString() + name;
        }

        return name;
    }

    public String doActivity(String name,
                             Environment ...environments) throws ActivityException {
        if (!canActivity(name)) {
            throw new CannotActivityException(createCannotActivityExceptionText(name));
        }

        for (Activity activity: activities) {
            if (activity.getName().equals(name)) {
                healthySense.checkEnvironmentForActivity(activity, environments);
                return activity.executeFor(this, environments);
            }
        }

        return null;
    }

    public String doActivity(String name,
                             Characteristic activityCharacteristic,
                             Environment ... environments) throws ActivityException {
        if (!canActivity(name)) {
            throw new CannotActivityException(createCannotActivityExceptionText(name));
        }

        for (Activity activity: activities) {
            if (activity.getName().equals(name)) {
                healthySense.checkEnvironmentForActivity(activity, environments);
                activity.withCharacteristic(activityCharacteristic);
                return activity.executeFor(this, environments);
            }
        }

        return null;
    }

    private boolean canActivity(String name) {
        for (Activity activity : activities) {
            if (activity.getName().equals(name)) {
                return true;
            }
        }

        return false;
    }
    private String createCannotActivityExceptionText(String activityName) {
        return this.getClass() + " " + this.name + ": 'I cannot do " + activityName + "!'";
    }


    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }

        if (!(object instanceof Pokemon)) {
            return false;
        }

        Pokemon pokemon = (Pokemon) object;
        if (!name.equals(pokemon.name)) {
            return false;
        }

        if (!isEqualActivities(pokemon.activities) || !isEqualCharacteristics(pokemon.characteristics)) {
            return false;
        }

        return true;
     }

    private boolean isEqualCharacteristics(List<Characteristic> characteristics) {
        ListContainsDeterminant<Characteristic> determinant = new ListContainsDeterminant<>();
        return determinant.isEqualList(characteristics, this.characteristics);
    }

    private boolean isEqualActivities(List<Activity> activities) {
        ListContainsDeterminant<Activity> determinant = new ListContainsDeterminant<>();
        return determinant.isEqualList(activities, this.activities);
    }


    private static class ListContainsDeterminant<T> {
        boolean isEqualList(List<T> listA, List<T> listB) {
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


    @Override
    public int hashCode() {
        int hashCode = name.hashCode();

        for (Characteristic characteristic : characteristics) {
            hashCode += characteristic.hashCode();
        }

        for (Activity activity : activities) {
            hashCode += activity.hashCode();
        }

        return hashCode;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder(this.getClass().toString() + name);

        for (Characteristic characteristic : characteristics) {
            string.append(characteristic.toString());
        }

        for (Activity activity : activities) {
            string.append(activity.toString());
        }

        return string.toString();
    }
}
