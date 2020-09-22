package com.internet.shop.dao.jdbc;

import com.internet.shop.dao.interfaces.OrderDao;
import com.internet.shop.exeptions.DataProcessingException;
import com.internet.shop.library.Dao;
import com.internet.shop.model.Order;
import com.internet.shop.model.Product;
import com.internet.shop.model.User;
import com.internet.shop.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Dao
public class OrderDaoJdbcImpl implements OrderDao {
    @Override
    public List<Order> getUserOrders(Long userId) {
        return null;
    }

    @Override
    public Order create(Order order) {
        String query = "INSERT INTO orders_products(order_id, product_id) VALUES(?,?)";
        try (Connection connection = ConnectionUtil.getConnection()) {
            for (Product product : order.getProducts()) {
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setLong(1, order.getOrder_id());
                statement.setLong(2, product.getId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't add products to order", e);
        }
        return order;
    }

    @Override
    public Optional<Order> getById(Long id) {
        Order order;
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM orders WHERE order_id = ? AND deleted = false");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                order = getOrderFromResultSet(resultSet);
                return Optional.of(order);
            }
            return Optional.empty();
        } catch (SQLException ex) {
            throw new DataProcessingException("Can't get product by " + id + " !", ex);
        }
    }

    @Override
    public Order update(Order order) {
        deleteById(order.getOrder_id());
        create(order);
        return order;
    }

    @Override
    public boolean deleteById(Long orderId) {
        String query = "DELETE FROM orders_products WHERE order_id=?";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, orderId);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DataProcessingException("Can't delete products from order", e);
        }
        return true;
    }

    @Override
    public List<Order> getAll() {
        List<Order> orders = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement =
                    connection.prepareStatement("SELECT * FROM orders WHERE deleted = false");
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Order order = getOrderFromResultSet(resultSet);
                orders.add(order);
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Get all orders is failed!", e);
        }
        return orders;
    }

    private Order getOrderFromResultSet(ResultSet resultSet) throws SQLException {
        Long orderId = resultSet.getLong("order_id");
        Long userId = resultSet.getLong("user_id");
        return new Order(orderId,);
    }

}
