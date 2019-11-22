package story.pokemon.healthySense;

import story.activity.Activity;
import story.activity.annotations.WithSingleObject;
import story.activity.annotations.WithTwoObject;
import story.activity.exception.ActivityException;
import story.activity.exception.NoObjectException;
import story.activity.exception.NotEnoughObjectsException;
import story.activity.exception.TooManyObjectsException;
import story.environment.Environment;

public class HealthySense {
    public void checkEnvironmentForActivity(Activity activity,
                                            Environment...environments) throws ActivityException {
        checkWithSingleObjectActivity(activity, environments);
        checkWithTwoObjectActivity(activity, environments);
    }
    private void checkWithSingleObjectActivity(Activity activity, Environment ...environments) throws ActivityException {
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
    private void checkWithTwoObjectActivity(Activity activity, Environment... environments) throws ActivityException {
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
