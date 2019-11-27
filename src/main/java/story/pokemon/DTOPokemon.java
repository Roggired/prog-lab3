package story.pokemon;

import repository.annotations.DTO;
import repository.annotations.Id;
import repository.annotations.Stored;
import story.environment.feature.Feature;

import java.util.List;

@DTO
public class DTOPokemon {
    @Id
    @Stored
    public Integer id;
    @Stored
    public String name;
    public List<String> activitiesNames;
    public List<String> characteristicsStrings;
    public List<Feature> features;

    public DTOPokemon() {}
}
