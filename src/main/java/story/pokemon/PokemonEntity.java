package story.pokemon;

import repository.annotations.Entity;
import repository.annotations.Id;
import repository.annotations.Stored;
import story.environment.feature.Feature;

import java.util.List;

@Entity
public class PokemonEntity {
    @Id
    public Integer id;

    @Stored(TableKey = "Names")
    public String name;

    @Stored(TableKey = "Activities")
    public List<String> activitiesNames;

    @Stored(TableKey = "Characteristics")
    public List<String> characteristicsStrings;

    @Stored(TableKey = "Features")
    public List<String> featuresStrings;

    public PokemonEntity() {}
}
