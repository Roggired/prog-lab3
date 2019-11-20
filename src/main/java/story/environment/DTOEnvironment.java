package story.environment;

import com.fasterxml.jackson.annotation.JsonProperty;
import story.environment.feature.Feature;

import java.util.List;

public class DTOEnvironment {
    @JsonProperty
    public String name;

    @JsonProperty
    public List<Feature> features;
}
