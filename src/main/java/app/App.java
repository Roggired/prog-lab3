package app;

import story.StoryTailer;
import story.StoryTailerConfiguration;
import story.activity.exception.*;
import app.injector.FactoryModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.*;
import stuff.AbstractClass;
import stuff.Enum;

public class App {
    public static void main(String[] args) throws ActivityException {
        ObjectMapper objectMapper = new ObjectMapper();
        Injector injector = Guice.createInjector(new FactoryModule());
        StoryTailerConfiguration storyTailerConfiguration = createStoryTailerConfiguration();

        StoryTailer storyTailer = new StoryTailer(injector,
                                                  objectMapper,
                                                  storyTailerConfiguration);

        String story = storyTailer.tellStory();

        System.out.println(story);

        System.out.println(Enum.THIS + " " + Enum.IS + " " + Enum.ENUM);

        class MyCoolClass extends AbstractClass {
            @Override
            public void yeahAaaabstract() {
                System.out.println("Do some abstract stuff");
            }
        }
        new MyCoolClass().yeahAaaabstract();
    }

    private static StoryTailerConfiguration createStoryTailerConfiguration() {
        StoryTailerConfiguration storyTailerConfiguration = new StoryTailerConfiguration();

        storyTailerConfiguration.pokemonJsonDirectory = "jsons/pokemons/";
        storyTailerConfiguration.filleJsonFileName = "fille.json";
        storyTailerConfiguration.rulleJsonFileName = "rulle.json";
        storyTailerConfiguration.oskarJsonFileName = "oskar.json";
        storyTailerConfiguration.karlsonJsonFileName = "karlson.json";

        storyTailerConfiguration.environmentJsonDirectory = "jsons/environments/";
        storyTailerConfiguration.hallJsonFileName = "hall.json";
        storyTailerConfiguration.underWindowJsonFileName = "underWindow.json";
        storyTailerConfiguration.walletJsonFileName = "wallet.json";
        storyTailerConfiguration.soupBownJsonFileName = "soupBowl.json";
        storyTailerConfiguration.watchesJsonFileName = "watches.json";
        storyTailerConfiguration.lampJsonFileName = "lamp.json";

        return storyTailerConfiguration;
    }
}
