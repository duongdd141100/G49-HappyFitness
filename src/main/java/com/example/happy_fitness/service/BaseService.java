package com.example.happy_fitness.service;

import java.util.List;

public interface BaseService<T> {
    T create(T t);

    T update(T t, Float id);

    void delete(List<Float> ids);
}
