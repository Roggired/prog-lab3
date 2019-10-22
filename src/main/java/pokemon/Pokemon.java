package pokemon;

import activity.CannotActivityException;
import activity.IActivity;

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


    public void learnActivity(IActivity activity) {
        activities.add(activity);
    }
    public void doActivity(String name) throws CannotActivityException {
        if (!canActivity(name)) {
            throw new CannotActivityException(createCannotActivityExceptionText(name));
        }

        for (IActivity activity: activities) {
            if (activity.getName().equals(name)) {
                activity.executeFor(this);
            }
        }
    }
    private boolean canActivity(String name) {
        boolean can = false;

        for (IActivity activity : activities) {
            if (activity.getName().equals(name)) {
                can = true;
                break;
            }
        }

        return can;
    }
    private String createCannotActivityExceptionText(String activityName) {
        return this.getClass() + " " + this.name + ": 'I cannot do " + activityName + "!'";
    }
}
