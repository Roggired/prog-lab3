package app;

import activity.*;
import activity.exception.*;
import app.injector.FactoryModule;
import characteristic.Characteristic;
import com.google.inject.*;
import environment.Environment;
import environment.IEnvironmentFactory;
import environment.feature.Feature;
import pokemon.IPokemonFactory;
import pokemon.Pokemon;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws ActivityException {
        Injector injector = Guice.createInjector(new FactoryModule());

        IPokemonFactory pokemonFactory = injector.getInstance(IPokemonFactory.class);
        Pokemon fille = pokemonFactory.create("Филле", new ArrayList<IActivity>() {{
            add(new GoIn());
            add(new See());
        }});
        Pokemon rulle = pokemonFactory.create("Рулле", new ArrayList<IActivity>() {{
            add(new GoIn());
            add(new See());
        }});
        Pokemon oskar = pokemonFactory.create("Оскар", new ArrayList<IActivity>() {{
            add(new StayAlong());
            add(new Bore());
            add(new GoIn());
            add(new See());
        }});
        Pokemon karlson = pokemonFactory.create("Карлсон", new ArrayList<IActivity>() {{
            add(new GoOver());
            add(new PutIn());
            add(new AttachTo());
        }});

        IEnvironmentFactory environmentFactory = injector.getInstance(IEnvironmentFactory.class);
        Environment hall = environmentFactory.create("прихожая", new ArrayList<Feature>() {{
            add(new Feature(GoIn.REQUIRED_FEATURE));
        }});
        Environment underWindow = environmentFactory.create("подоконник", new ArrayList<Feature>() {{
            add(new Feature(GoOver.REQUIRED_FEATURE));
        }});
        Environment wallet = environmentFactory.create("бумажник", new ArrayList<Feature>() {{
            add(new Feature(PutIn.OBJECT_REQUIRED_FEATURE));
        }});
        Environment soupBowl = environmentFactory.create("суповая миска", new ArrayList<Feature>() {{
            add(new Feature(PutIn.CONTAINER_REQUIRED_FEATURE));
        }});
        Environment watches = environmentFactory.create("часы", new ArrayList<Feature>() {{
            add(new Feature(AttachTo.OBJECT_REQUIRED_FEATURE));
        }});
        Environment lamp = environmentFactory.create("лампа", new ArrayList<Feature>() {{
            add(new Feature(AttachTo.CONTAINER_REQUIRED_FEATURE));
        }});

        fille.doActivity(System.out, GoIn.NAME, hall);
        rulle.doActivity(System.out, GoIn.NAME, hall);
        oskar.doActivity(System.out, StayAlong.NAME);
        oskar.doActivity(System.out, Bore.NAME);
        oskar.doActivityBecause("Чтобы посмотреть, что делают его новые друзья", System.out, GoIn.NAME, hall);
        karlson.doActivity(System.out, GoOver.NAME, underWindow);
        karlson.doActivity(System.out, PutIn.NAME, wallet, soupBowl);
        wallet.addCharacteristic(new Characteristic("сухой, потому что Филле, Рулле и Оскар уже съели весь суп"));
        System.out.println(wallet.getNameWithCharacteristics());
        karlson.doActivity(System.out, AttachTo.NAME, watches, lamp);
        watches.addCharacteristic(new Characteristic("висели на виду, слегка раскачиваясь"));
        System.out.println(watches.getNameWithCharacteristics());
        fille.doActivityBecause("Когда вернулся в комнату", System.out, See.NAME, watches);
        rulle.doActivityBecause("Когда вернулся в комнату", System.out, See.NAME, watches);
        oskar.doActivityBecause("Когда вернулся в комнату", System.out, See.NAME, watches);
    }
}
