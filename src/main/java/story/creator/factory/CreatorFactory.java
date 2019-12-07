package story.creator.factory;

import com.google.inject.AbstractModule;
import com.google.inject.Injector;
import repository.Repository;
import story.creator.Creator;
import story.creator.GuiceCreator;
import story.environment.EnvironmentEntity;
import story.pokemon.PokemonEntity;

public interface CreatorFactory {
    Creator create(Repository<PokemonEntity> pokemonEntityRepository,
                   Repository<EnvironmentEntity> environmentEntityRepository);
}
