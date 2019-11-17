package pokemonTest;

import story.activity.IActivity;
import story.activity.StayAlong;
import story.activity.exception.ActivityException;
import org.junit.Assert;
import org.junit.Test;
import story.pokemon.Pokemon;
import story.pokemon.healthySense.HealthySense;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class testSuite extends Assert {
    @Test
    public void testSomeCoolFeature() throws ActivityException {
        IActivity stayAlong = new StayAlong();
        Pokemon pokemon = new Pokemon("Pokemosha", new ArrayList<IActivity>() {{
            add(stayAlong);
        }}, null, new HealthySense());

        String expectedString = new String("Pokemosha остался один".getBytes(), StandardCharsets.UTF_8);
        assertEquals("Stay along: ", expectedString, pokemon.doActivity(StayAlong.NAME));
    }
}
