package story.environment;

import com.fasterxml.jackson.annotation.JsonProperty;
import repository.annotations.Entity;
import repository.annotations.Id;
import repository.annotations.Stored;
import story.environment.feature.Feature;

import java.util.List;

@Entity
public class EnvironmentEntity {
    @Id
    public Integer id;

    @JsonProperty
    @Stored(TableKey = "Names")
    public String name;

    @Stored(TableKey = "Characteristics")
    public List<String> characteristicsStrings;

    @JsonProperty
    @Stored(TableKey = "Features")
    public List<String> featuresStrings;
}
