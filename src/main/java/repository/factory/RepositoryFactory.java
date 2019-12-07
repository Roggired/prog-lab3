package repository.factory;

import repository.Repository;
import story.pokemon.PokemonEntity;

public interface RepositoryFactory<T> {
    Repository<T> create(String path);
}
