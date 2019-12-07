package story.teller.factory;

import repository.configuration.ConfigurationReader;
import story.creator.Creator;
import story.teller.StoryTeller;

public interface StoryTellerFactory {
    StoryTeller create(ConfigurationReader configurationReader, Creator creator);
}
