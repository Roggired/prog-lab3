package app;

import app.injector.Lab3Module;
import app.injector.Lab4Module;
import story.teller.StoryTeller;
import story.activity.exception.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.*;

public class App {
    public static void main(String[] args) throws ActivityException {
        ObjectMapper objectMapper = new ObjectMapper();
        Injector injector = Guice.createInjector(new Lab4Module());

        StoryTeller storyTeller = injector.getInstance(StoryTeller.class);
        String story = storyTeller.tellStory(injector, objectMapper);

        System.out.println(story);
    }
}
