package pokemon;

import activity.IActivity;

import java.util.List;

public interface IPokemonFactory {
    Pokemon create(String name, List<IActivity> activities);
}
