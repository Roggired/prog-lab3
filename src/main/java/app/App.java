package app;

import story.teller.StoryTeller;
import story.activity.exception.*;
import app.injector.Lab3Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.*;
import stuff.AbstractClass;
import stuff.Enum;

public class App {
    public static void main(String[] args) throws ActivityException {
        ObjectMapper objectMapper = new ObjectMapper();
        Injector injector = Guice.createInjector(new Lab3Module());

        StoryTeller storyTeller = injector.getInstance(StoryTeller.class);
        String story = storyTeller.tellStory(injector, objectMapper);

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
}
