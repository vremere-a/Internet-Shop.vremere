package com.internet.shop.dao.impl;

import com.internet.shop.dao.OrderDAO;
import com.internet.shop.model.Order;

import java.util.List;
import java.util.Optional;

public class OrderDaoImpl implements OrderDAO {
    @Override
    public Order create(Order order) {
        return null;
    }

    @Override
    public Optional<Order> getById(Order id) {
        return Optional.empty();
    }

    @Override
    public Order update(Order order) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public List<Order> getAllOrders() {
        return null;
    }
}
