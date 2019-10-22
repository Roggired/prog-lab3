package pokemon;

import activity.*;
import activity.exception.CannotActivityException;
import activity.exception.NoFeatureException;
import activity.exception.NoObjectException;
import activity.exception.TooManyObjectsException;
import environment.Environment;

import java.io.PrintStream;
import java.util.List;

public class Pokemon {
    private String name;
    private List<IActivity> activities;


    public Pokemon(String name) {
        this.name = name;
    }
    public Pokemon(String name, List<IActivity> activities) {
        this.name = name;
        this.activities = activities;
    }


    public String getName() {
        return name;
    }
    public void printInfo(PrintStream printStream) {
        StringBuilder stringBuilder = new StringBuilder(name);
        stringBuilder.append(" can:");
        activities.forEach(activity -> {
            stringBuilder.append(System.lineSeparator() + activity.getName());
        });

        printStream.println(stringBuilder.toString());
    }


    public void learnActivity(IActivity activity) {
        activities.add(activity);
    }
    public void doActivity(PrintStream printStream,
                           String name,
                           Environment ...environments) throws CannotActivityException,
            NoObjectException,
            NoFeatureException,
            TooManyObjectsException {
        if (!canActivity(name)) {
            throw new CannotActivityException(createCannotActivityExceptionText(name));
        }

        for (IActivity activity: activities) {
            if (activity.getName().equals(name)) {
                activity.executeFor(printStream, this, environments);
            }
        }
    }
    private boolean canActivity(String name) {
        for (IActivity activity : activities) {
            if (activity.getName().equals(name)) {
                return true;
            }
        }

        return false;
    }
    private String createCannotActivityExceptionText(String activityName) {
        return this.getClass() + " " + this.name + ": 'I cannot do " + activityName + "!'";
    }
}
