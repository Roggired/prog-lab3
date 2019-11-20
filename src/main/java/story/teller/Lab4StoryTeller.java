package story.teller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Injector;
import story.activity.exception.ActivityException;

public class Lab4StoryTeller extends StoryTeller {
    @Override
    public String tellStory(Injector injector, ObjectMapper objectMapper) throws ActivityException {
        return null;
    }
}
