package repository;

import repository.exception.RepositoryException;

import java.sql.Connection;
import java.util.Iterator;

public abstract class Repository<T> {
    protected Connection connection;


    public abstract void save(T object) throws RepositoryException;

    public abstract T get(T object) throws RepositoryException;

    public abstract void modify(T object) throws RepositoryException;

    public abstract void delete(T object) throws RepositoryException;

    public abstract Iterator<T> getAll();
}
