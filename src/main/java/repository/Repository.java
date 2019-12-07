package repository;

import repository.exception.RepositoryException;

import java.util.Iterator;

public interface Repository<T> {
    void save(T object) throws RepositoryException;

    T get(Class<T> clazz, Integer id) throws RepositoryException;

    void modify(T object) throws RepositoryException;

    void delete(T object) throws RepositoryException;

    Iterator<T> getAll();
}
