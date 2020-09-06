package com.internet.shop.dao;

import com.internet.shop.model.Order;
import java.util.List;
import java.util.Optional;

public interface OrderDAO {

    Order create(Order order);

    Optional<Order> getById(Long id);

    boolean deleteById(Long id);

    List<Order> getAllOrders();

    List<Order> getUserOrders(Long userId);
}
