package com.example.happy_fitness.service;

public interface BaseService<T> {
    T create(T t);

    T update(T t, Float id);

    void delete(Float id);
}
