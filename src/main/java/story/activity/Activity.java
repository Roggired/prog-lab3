package story.activity;

import story.activity.exception.ActivityException;
import story.activity.exception.NoFeatureException;
import story.characteristic.Characteristic;
import story.environment.Environment;
import story.pokemon.Pokemon;

public abstract class Activity {
    protected Characteristic characteristic;


    public Activity() {
        characteristic = new Characteristic("");
    }

    public void withCharacteristic(Characteristic characteristic) {
        this.characteristic = characteristic;
    }

    public abstract String getName();

    public abstract String executeFor(Pokemon pokemon,
                                      Environment ...environments) throws ActivityException;


    protected void checkObjectRequiredFeature(String requiredFeature,
                                                Environment ...environments) throws NoFeatureException {
        if (!environments[0].haveFeature(requiredFeature)) {
            throw new NoFeatureException("объект активности не имеет необходимой фичи");
        }
    }

    protected void checkContainerRequiredFeature(String requiredFeature,
                                                   Environment ...environments) throws NoFeatureException {
        if (!environments[1].haveFeature(requiredFeature)) {
            throw new NoFeatureException("контайнер для объекта активности не имеет необходимой фичи");
        }
    }
}
