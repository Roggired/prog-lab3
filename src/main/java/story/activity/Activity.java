package story.activity;

import story.activity.exception.ActivityException;
import story.activity.exception.NoFeatureException;
import story.activity.exception.NotEnoughObjectsException;
import story.environment.Environment;
import story.pokemon.Pokemon;

public abstract class Activity {
    public abstract String getName();

    public abstract String executeFor(Pokemon pokemon,
                                      Environment ...environments) throws ActivityException;


    protected void checkEnougthEnvironments(int requiredAmount,
                                              Environment ...environments) throws NotEnoughObjectsException {
        if (environments.length < requiredAmount) {
            throw new NotEnoughObjectsException("недостаточно параметров");
        }
    }

    protected void checkObjectRequiredFeature(String requiredFeature,
                                                Environment ...environments) throws NoFeatureException {
        if (environments[0].haveFeature(requiredFeature)) {
            throw new NoFeatureException("объект активности не имеет необходимой фичи");
        }
    }

    protected void checkContainerRequiredFeature(String requiredFeature,
                                                   Environment ...environments) throws NoFeatureException {
        if (environments[1].haveFeature(requiredFeature)) {
            throw new NoFeatureException("контайнер для объекта активности не имеет необходимой фичи");
        }
    }
}
