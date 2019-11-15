package pokemonTest;

import activity.IActivity;
import activity.StayAlong;
import activity.exception.ActivityException;
import org.junit.Assert;
import org.junit.Test;
import pokemon.Pokemon;
import pokemon.healthySense.HealthySense;

import java.io.UnsupportedEncodingException;
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
