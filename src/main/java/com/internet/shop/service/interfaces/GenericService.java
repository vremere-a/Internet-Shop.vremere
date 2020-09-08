package com.internet.shop.service.interfaces;

import java.util.List;

public interface GenericService<T, V> {
    T getById(V id);

    List<T> getAll();

    boolean deleteById(V id);

    T create(T element);
}
