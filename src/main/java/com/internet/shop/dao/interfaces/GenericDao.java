package com.internet.shop.dao.interfaces;

import java.util.List;
import java.util.Optional;

public interface GenericDao<T, V> {
    T create(T element);

    Optional<T> getById(V id);

    T update(T element);

    boolean deleteById(V id);

    List<T> getAll();
}
