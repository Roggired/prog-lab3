package pokemon;

import activity.*;
import activity.annotations.WithSingleObject;
import activity.annotations.WithTwoObject;
import activity.exception.*;
import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;
import environment.Environment;
import characteristic.Characteristic;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Pokemon {
    private String name;
    private List<IActivity> activities;
    private List<Characteristic> characteristics;


    @AssistedInject
    public Pokemon(@Assisted String name, @Assisted List<IActivity> activities) {
        this.name = name;
        this.activities = activities;
    }


    public void addCharacteristic(Characteristic characteristic) {
        if (characteristics == null) {
            characteristics = new ArrayList<>();
        }

        characteristics.add(characteristic);
    }
    public void setCharacteristics(List<Characteristic> characteristics) {
        this.characteristics = characteristics;
    }
    public String getName() {
        if (characteristics != null && !characteristics.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            characteristics.forEach(characteristic -> stringBuilder.append(characteristic.getName() + " "));

            return stringBuilder.toString() + name;
        }

        return name;
    }
    public void printInfo(PrintStream printStream) {
        StringBuilder stringBuilder = new StringBuilder(getName());
        stringBuilder.append(" can:");
        activities.forEach(activity -> stringBuilder.append(System.lineSeparator() + activity.getName()));

        printStream.println(stringBuilder.toString());
    }


    public void learnActivity(IActivity activity) {
        activities.add(activity);
    }
    public void doActivity(PrintStream printStream,
                           String name,
                           Environment ...environments) throws ActivityException {
        if (!canActivity(name)) {
            throw new CannotActivityException(createCannotActivityExceptionText(name));
        }

        for (IActivity activity: activities) {
            if (activity.getName().equals(name)) {
                checkEnvironmentForActivity(activity, environments);
                activity.executeFor(printStream, this, environments);
            }
        }
    }
    public void doActivityBecause(String cause,
                                  PrintStream printStream,
                                  String name,
                                  Environment ...environments) throws ActivityException {
        doActivity(printStream, name, environments);
        printStream.println(cause);
    }
    private boolean canActivity(String name) {
        for (IActivity activity : activities) {
            if (activity.getName().equals(name)) {
                return true;
            }
        }

        return false;
    }
    //TODO: инкапсулировать логику проверок
    private void checkEnvironmentForActivity(IActivity activity, Environment ...environments) throws ActivityException {
        checkWithSingleObjectActivity(activity, environments);
        checkWithTwoObjectActivity(activity, environments);
    }
    private void checkWithSingleObjectActivity(IActivity activity, Environment ...environments) throws ActivityException {
        Object object = activity.getClass().getAnnotation(WithSingleObject.class);
        if (object != null) {
            if (environments.length == 0) {
                throw new NoObjectException(activity.getName() + " is " + object.toString());
            }

            if (environments.length > 1) {
                throw new TooManyObjectsException(activity.getName() + " is " + object.toString());
            }
        }
    }
    private void checkWithTwoObjectActivity(IActivity activity, Environment... environments) throws ActivityException {
        Object object = activity.getClass().getAnnotation(WithTwoObject.class);
        if (object != null) {
            if (environments.length == 0) {
                throw new NoObjectException(activity.getName() + " is " + object.toString());
            }

            if (environments.length == 1) {
                throw new NotEnoughObjectsException(activity.getName() + " is " + object.toString());
            }

            if (environments.length > 2) {
                throw new TooManyObjectsException(activity.getName() + " is " + object.toString());
            }
        }
    }
    private String createCannotActivityExceptionText(String activityName) {
        return this.getClass() + " " + this.name + ": 'I cannot do " + activityName + "!'";
    }
}
