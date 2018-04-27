package com.mattia.robotpuzzle.datasource.repositoryInterface;

public interface RepositoryInterface<T> {

    public T find();

    public T place(T t);

    public T update(T t);
}
