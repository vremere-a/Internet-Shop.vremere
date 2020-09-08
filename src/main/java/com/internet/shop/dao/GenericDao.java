package com.internet.shop.dao;

import com.internet.shop.model.User;

import java.util.List;
import java.util.Optional;

public interface GenericDao<T, V> {
    T create(T item);

    Optional<T> getById(V id);

    T update(T item);

    boolean deleteById(V id);

    List<T> getAll();
}
