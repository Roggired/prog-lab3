package app;

import activity.*;
import activity.exception.*;
import activity.factory.IActivityFactory;
import app.injector.FactoryModule;
import characteristic.Characteristic;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.*;
import environment.Environment;
import pokemon.DTOPokemon;
import pokemon.factory.IPokemonFactory;
import pokemon.Pokemon;
import stuff.AbstractClass;
import stuff.Enum;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class App {
    private static final String ENVIRONMENT_JSONS_DIRECTORY = "jsons/environments/";
    private static final String POKEMON_JSONS_DIRECTORY = "jsons/pokemons/";


    public static void main(String[] args) throws ActivityException {
        ObjectMapper mapper = new ObjectMapper();
        Injector injector = Guice.createInjector(new FactoryModule());

        Pokemon fille = createPokemonFromJSON("fille.json", mapper, injector);
        Pokemon rulle = createPokemonFromJSON("rulle.json", mapper, injector);
        Pokemon oskar = createPokemonFromJSON("oskar.json", mapper, injector);
        Pokemon karlson = createPokemonFromJSON("karlson.json", mapper, injector);

        Environment hall = createEnvironmentFromJSON("hall.json", mapper);
        Environment underWindow = createEnvironmentFromJSON("underWindow.json", mapper);
        Environment wallet = createEnvironmentFromJSON("wallet.json", mapper);
        Environment soupBowl = createEnvironmentFromJSON("soupBowl.json", mapper);
        Environment watches = createEnvironmentFromJSON("watches.json", mapper);
        Environment lamp = createEnvironmentFromJSON("lamp.json", mapper);

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


        System.out.println();
        System.out.println();

        System.out.println(Enum.THIS + " " + Enum.IS + " " + Enum.ENUM);

        class MyCoolClass extends AbstractClass {
            @Override
            public void yeahAaaabstract() {
                System.out.println("Do some abstract stuff");
            }
        }
        new MyCoolClass().yeahAaaabstract();

    }

    private static Pokemon createPokemonFromJSON(String fileName,
                                          ObjectMapper objectMapper,
                                          Injector injector) {
        DTOPokemon dtoPokemon = null;
        try {
            dtoPokemon = objectMapper.readValue(
                    Objects.requireNonNull(App.class.getClassLoader()
                            .getResourceAsStream(POKEMON_JSONS_DIRECTORY + fileName)), DTOPokemon.class);
        } catch (IOException exception) {
            exception.printStackTrace();
            System.exit(1);
        }

        IActivityFactory activityFactory = injector.getInstance(IActivityFactory.class);
        IPokemonFactory pokemonFactory = injector.getInstance(IPokemonFactory.class);

        List<Characteristic> characteristics = new ArrayList<>();
        dtoPokemon.characteristicsStrings.forEach(string -> characteristics.add(new Characteristic(string)));

        return pokemonFactory.create(dtoPokemon.name, characteristics, activityFactory.create(dtoPokemon.activitiesNames));
    }
    private static Environment createEnvironmentFromJSON(String fileName,
                                                         ObjectMapper objectMapper) {
        try {
            return objectMapper.readValue(Objects.requireNonNull(
                    App.class.getClassLoader()
                            .getResourceAsStream(ENVIRONMENT_JSONS_DIRECTORY + fileName)), Environment.class);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        return null;
    }
}
