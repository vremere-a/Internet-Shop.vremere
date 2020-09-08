package com.internet.shop.dao.implementations;

import com.internet.shop.dao.interfaces.OrderDao;
import com.internet.shop.database.Storage;
import com.internet.shop.library.Dao;
import com.internet.shop.model.Order;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Dao
public class OrderDaoImpl implements OrderDao {
    @Override
    public Order create(Order order) {
        Storage.addOrder(order);
        return order;
    }

    @Override
    public Optional<Order> getById(Long id) {
        return getAll().stream()
                .filter(order -> order.getUserId().equals(id))
                .findFirst();
    }

    @Override
    public Order update(Order item) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return Storage.orders.removeIf(o -> o.getId().equals(id));
    }

    @Override
    public List<Order> getAll() {
        return Storage.orders;
    }

    @Override
    public List<Order> getUserOrders(Long userId) {
        return getAll().stream()
                .filter(order -> order.getUserId().equals(userId))
                .collect(Collectors.toList());
    }
}
