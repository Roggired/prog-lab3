package story.activity;

import story.activity.annotations.WithoutSubject;
import story.activity.exception.ActivityException;
import story.activity.exception.NoFeatureException;
import story.characteristic.Characteristic;
import story.environment.Environment;
import story.pokemon.Pokemon;
import story.reason.Reason;

import java.util.List;

/**
 * Представляет собой абстракцию всех активностей.
 * Использует паттер "шаблонный метод":
 *
 */
public abstract class Activity {
    protected Pokemon pokemon;
    protected Environment[] environments;
    protected Characteristic characteristic;
    protected String reasonPreposition;
    protected List<Reason> reasons;


    public void withCharacteristic(Characteristic characteristic) {
        this.characteristic = characteristic;
    }

    public void withReasons(String reasonPreposition, List<Reason> reasons) {
        this.reasonPreposition = reasonPreposition;
        this.reasons = reasons;
    }

    public abstract String getName();

    public final String executeFor(Pokemon pokemon,
                             Environment ...environments) throws ActivityException{
        this.pokemon = pokemon;
        this.environments = environments;

        String result = "";

        if (this.getClass().getAnnotation(WithoutSubject.class) == null) {
            result = appendPokemonName(result);
        }

        result = appendCharacteristic(result);
        result = appendExecutionResult(result);
        result = appendReasons(result);

        return result;
    }

    protected String appendPokemonName(String result) {
        return result + pokemon.getName();
    }
    protected String appendCharacteristic(String result) {
        if (characteristic == null) {
            return result;
        }

        return result +  " " + characteristic.getName() + " ";
    }
    protected abstract String appendExecutionResult(String result) throws ActivityException;

    protected String appendReasons(String result) {
        if (reasons == null) {
            return result;
        }

        StringBuilder stringBuilder = new StringBuilder(result + " ");
        reasons.forEach(reason -> stringBuilder.append(reason.getDescription()).append(" "));

        return stringBuilder.toString().trim();
    }

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
