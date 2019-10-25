package pokemon.healthySense;

import activity.IActivity;
import activity.annotations.WithSingleObject;
import activity.annotations.WithTwoObject;
import activity.exception.ActivityException;
import activity.exception.NoObjectException;
import activity.exception.NotEnoughObjectsException;
import activity.exception.TooManyObjectsException;
import environment.Environment;

public class HealthySense {
    public void checkEnvironmentForActivity(IActivity activity,
                                            Environment...environments) throws ActivityException {
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
}
