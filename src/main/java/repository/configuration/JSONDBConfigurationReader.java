package repository.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;
import jsonreader.JSONReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class JSONDBConfigurationReader implements ConfigurationReader {
    private JSONReader<NameIdPair> jsonReader;
    private String fullFileName;


    @AssistedInject
    public JSONDBConfigurationReader(@Assisted String fullFileName,
                                     @Assisted JSONReader<NameIdPair> jsonReader) {
        this.fullFileName = fullFileName;
        this.jsonReader = jsonReader;
    }


    @Override
    public Integer readID(String name) {
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream(fullFileName)));

            return ((Long)jsonObject.get(name)).intValue();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            System.exit(1);
        }

        return null;
    }


    public static class NameIdPair {
        @JsonProperty()
        private Integer id;
        private String name;
    }
}
