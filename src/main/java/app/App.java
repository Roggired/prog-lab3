package app;

import activity.*;
import activity.exception.CannotActivityException;
import activity.exception.NoFeatureException;
import activity.exception.NoObjectException;
import activity.exception.TooManyObjectsException;
import environment.Environment;
import environment.feature.Feature;
import pokemon.Pokemon;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws NoObjectException, CannotActivityException, NoFeatureException, TooManyObjectsException {
        Pokemon pokemon = new Pokemon("Муми-папа", new ArrayList<IActivity>() {{
            add(new Sit());
        }});

        Environment rock = new Environment("камень", new ArrayList<Feature>() {{
            add(new Feature("можно сидеть"));
        }});

        pokemon.doActivity(System.out, "присесть", rock);
    }
}
