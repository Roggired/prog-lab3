package story.environment;

import com.fasterxml.jackson.annotation.JsonProperty;
import repository.annotations.DTO;
import repository.annotations.Id;
import repository.annotations.Stored;
import story.environment.feature.Feature;

import java.util.List;

@DTO
public class DTOEnvironment {
    @Id
    @Stored
    public Integer id;

    @JsonProperty
    @Stored
    public String name;

    @JsonProperty
    public List<Feature> features;
}
