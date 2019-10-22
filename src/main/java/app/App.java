package app;

import activity.*;
import activity.exception.CannotActivityException;
import activity.exception.NoFeatureException;
import activity.exception.NoObjectException;
import activity.exception.TooManyObjectsException;
import environment.Environment;
import environment.feature.Feature;
import pokemon.Pokemon;
import pokemon.characteristic.Characteristic;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws NoObjectException, CannotActivityException, NoFeatureException, TooManyObjectsException {
        Pokemon fille = new Pokemon("Филле", new ArrayList<IActivity>() {{
            add(new Go());
        }});
        Pokemon rulle = new Pokemon("Рулле", new ArrayList<IActivity>() {{
            add(new Go());
        }});
        Pokemon oskar = new Pokemon("Оскар", new ArrayList<IActivity>() {{
            add(new Sit());
        }});
        oskar.addCharacteristic(new Characteristic("бедный"));

        Environment hall = new Environment("прихожая", new ArrayList<Feature>() {{
            add(new Feature("можно идти"));
        }});
        Environment chair = new Environment("стул", new ArrayList<Feature>() {{
            add(new Feature("можно сидеть"));
        }});

        fille.doActivity(System.out, "идти", hall);
        rulle.doActivity(System.out, "идти", hall);
        oskar.doActivity(System.out, "присесть", chair);
    }
}
