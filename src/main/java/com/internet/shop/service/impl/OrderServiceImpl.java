package com.internet.shop.service.impl;

import com.internet.shop.dao.OrderDAO;
import com.internet.shop.dao.ShoppingCartDAO;
import com.internet.shop.lib.Inject;
import com.internet.shop.lib.Service;
import com.internet.shop.model.Order;
import com.internet.shop.model.ShoppingCart;
import com.internet.shop.service.OrderService;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Inject
    private OrderDAO orderDAO;

    @Inject
    private ShoppingCartDAO shoppingCartDAO;

    @Override
    public Order completeOrder(ShoppingCart shoppingCart) {
//        orderDAO.create(orderDAO.getUserOrders());
//        List.copyOf(shoppingCart.getProducts());
//        shoppingCartDAO.clear(shoppingCart);
        return null;
    }

    @Override
    public List<Order> getUserOrders(Long userId) {
        return orderDAO.getUserOrders(userId);
    }

    @Override
    public Order get(Long id) {
        return orderDAO.getById(id).get();
    }

    @Override
    public List<Order> getAll() {
        return orderDAO.getAllOrders();
    }

    @Override
    public boolean delete(Long id) {
        return orderDAO.deleteById(id);
    }
}
