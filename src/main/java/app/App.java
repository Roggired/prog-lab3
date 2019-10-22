package app;

import activity.*;
import activity.exception.*;
import environment.Environment;
import environment.feature.Feature;
import pokemon.Pokemon;
import pokemon.characteristic.Characteristic;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws ActivityException {
        Pokemon fille = new Pokemon("Филле", new ArrayList<IActivity>() {{
            add(new Go());
        }});
        Pokemon rulle = new Pokemon("Рулле", new ArrayList<IActivity>() {{
            add(new Go());
        }});
        Pokemon oskar = new Pokemon("Оскар", new ArrayList<IActivity>() {{
            add(new StayAlong());
        }});
        oskar.addCharacteristic(new Characteristic("бедный"));

        Environment hall = new Environment("прихожая", new ArrayList<Feature>() {{
            add(new Feature("можно идти"));
        }});
        Environment chair = new Environment("стул", new ArrayList<Feature>() {{
            add(new Feature("можно сидеть"));
        }});

        fille.doActivity(System.out, Go.NAME, hall);
        rulle.doActivity(System.out, Go.NAME, hall);
        oskar.doActivity(System.out, StayAlong.NAME);
    }
}
