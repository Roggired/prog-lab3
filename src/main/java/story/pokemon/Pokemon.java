package story.pokemon;

import story.activity.*;
import story.activity.exception.*;
import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;
import story.reason.ReasonProducer;
import story.environment.Environment;
import story.characteristic.Characteristic;
import story.environment.feature.Feature;
import story.pokemon.healthySense.HealthySense;
import story.reason.Reason;

import java.util.List;

public class Pokemon extends Environment implements ReasonProducer {
    private String name;
    private List<Activity> activities;
    private HealthySense healthySense;

    private Doer doer = new Doer();


    @AssistedInject
    public Pokemon(@Assisted String name,
                   @Assisted List<Activity> activities,
                   @Assisted List<Characteristic> characteristics,
                   @Assisted List<Feature> features,
                   HealthySense healthySense) {
        super(name, characteristics, features);
        this.name = name;
        this.activities = activities;
        this.healthySense = healthySense;
    }

    public void withCharacteristic(Characteristic characteristic) {
        doer.characteristic = characteristic;
    }
    public void withReasons(String reasonPreposition, List<Reason> reasons) {
        doer.reasonPreposition = reasonPreposition;
        doer.reasons = reasons;
    }
    public void withEnvironments(Environment ...environments) {
        doer.environments = environments;
    }

    public String doActivity(Class<?> activityClass) throws ActivityException {
        Activity activity = findActivity(activityClass);

        if (activity == null) {
            throw new CannotActivityException(createCannotActivityExceptionText(activityClass));
        }

        activity.withCharacteristic(doer.characteristic);
        activity.withReasons(doer.reasonPreposition, doer.reasons);

        healthySense.checkEnvironmentForActivity(activity, doer.environments);

        String result = activity.executeFor(this, doer.environments);

        doer = new Doer();
        return result;
    }

    private Activity findActivity(Class<?> activityClass) {
        for (Activity activity: activities) {
            if (activity.getClass().equals(activityClass)) {
                return activity;
            }
        }

        return null;
    }
    private String createCannotActivityExceptionText(Class<?> activityClass) {
        return this.getClass() + " " + this.name + ": 'I cannot do " + activityClass.getName() + "!'";
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

    private class Doer {
        private Environment[] environments;
        private Characteristic characteristic;
        private String reasonPreposition;
        private List<Reason> reasons;
    }
}
