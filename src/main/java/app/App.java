package app;

import activity.*;
import activity.exception.*;
import environment.Environment;
import environment.feature.Feature;
import pokemon.Pokemon;
import characteristic.Characteristic;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws ActivityException {
        Pokemon fille = new Pokemon("Филле", new ArrayList<IActivity>() {{
            add(new GoIn());
            add(new See());
        }});
        Pokemon rulle = new Pokemon("Рулле", new ArrayList<IActivity>() {{
            add(new GoIn());
            add(new See());
        }});
        Pokemon oskar = new Pokemon("Оскар", new ArrayList<IActivity>() {{
            add(new StayAlong());
            add(new Bore());
            add(new GoIn());
            add(new See());
        }});
        oskar.addCharacteristic(new Characteristic("бедный"));
        Pokemon karlson = new Pokemon("Карлсон", new ArrayList<IActivity>() {{
            add(new GoOver());
            add(new PutIn());
            add(new AttachTo());
        }});

        Environment hall = new Environment("прихожая", new ArrayList<Feature>() {{
            add(new Feature("можно идти"));
        }});
        Environment chair = new Environment("стул", new ArrayList<Feature>() {{
            add(new Feature("можно сидеть"));
        }});
        Environment underWindow = new Environment("подоконник", new ArrayList<Feature>() {{
            add(new Feature("можно перемахнуть"));
        }});
        Environment wallet = new Environment("бумажник", new ArrayList<Feature>() {{
            add(new Feature("это можно положить"));
        }});
        Environment soupBowl = new Environment("суповая миска", new ArrayList<Feature>() {{
            add(new Feature("в это можно положить"));
        }});
        Environment watches = new Environment("часы", new ArrayList<Feature>() {{
            add(new Feature("это можно прикрепить"));
        }});
        Environment lamp = new Environment("лампа", new ArrayList<Feature>() {{
            add(new Feature("к этому можно прикрепить"));
        }});

        fille.doActivity(System.out, GoIn.NAME, hall);
        rulle.doActivity(System.out, GoIn.NAME, hall);
        oskar.doActivity(System.out, StayAlong.NAME);
        oskar.doActivity(System.out, Bore.NAME);
        oskar.doActivityBecause("Чтобы посмотреть, что делают его новые друзья",
                                System.out, GoIn.NAME, hall);
        karlson.doActivity(System.out, GoOver.NAME, underWindow);
        karlson.doActivity(System.out, PutIn.NAME, wallet, soupBowl);
        wallet.addCharacteristic(new Characteristic("сухой, потому что Филле, Рулле и Оскар уже съели весь суп"));
        wallet.printInfo(System.out);
        karlson.doActivity(System.out, AttachTo.NAME, watches, lamp);
        watches.addCharacteristic(new Characteristic("они висели на виду, слегка раскачиваясь"));
        watches.printInfo(System.out);
        fille.doActivityBecause("Когда вернулся в комнату",
                                System.out, See.NAME, watches);
        rulle.doActivityBecause("Когда вернулся в комнату",
                                System.out, See.NAME, watches);
        oskar.doActivityBecause("Когда вернулся в комнату",
                                System.out, See.NAME, watches);
    }
}
