package com.internet.shop.dao.impl;

import com.internet.shop.dao.OrderDAO;
import com.internet.shop.db.Storage;
import com.internet.shop.lib.Dao;
import com.internet.shop.model.Order;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Dao
public class OrderDaoImpl implements OrderDAO {
    @Override
    public Order create(Order order) {
        Storage.addOrder(order);
        return order;
    }

    @Override
    public Optional<Order> getById(Long id) {
        return getAllOrders().stream()
                .filter(order -> order.getUserId().equals(id))
                .findFirst();
    }

    @Override
    public boolean deleteById(Long id) {
        return Storage.orders.removeIf(o -> o.getId().equals(id));
    }

    @Override
    public List<Order> getAllOrders() {
        return Storage.orders;
    }

    @Override
    public List<Order> getUserOrders(Long userId) {
        return getAllOrders().stream()
                .filter(order -> order.getUserId().equals(userId))
                .collect(Collectors.toList());
    }
}
