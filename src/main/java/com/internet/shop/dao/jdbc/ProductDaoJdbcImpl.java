package com.internet.shop.dao.jdbc;

import com.internet.shop.dao.interfaces.ProductDao;
import com.internet.shop.exeptions.DataProcessingException;
import com.internet.shop.model.Product;
import com.internet.shop.util.ConnectionUtil;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class ProductDaoJdbcImpl implements ProductDao {
    private static final String QUERY_CREATE =
            "INSERT INTO products (product_name, price) VALUES (?, ?)";
    private static final String QUERY_GET_ID =
            "SELECT * FROM products WHERE product_id = ?";
    private static final String QUERY_UPDATE =
            "UPDATE products SET productName = ?, price = ? WHERE product_id = ?";
    private static final String QUERY_DELETE =
            "UPDATE products SET deleted = true WHERE product_id = ?";
    private static final String QUERY_GET_ALL =
            "SELECT * FROM products";

    @Override
    public Product create(Product element) {

        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection
                    .prepareStatement(QUERY_CREATE, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, element.getName());
            statement.setDouble(2, element.getPrice());
            statement.executeQuery();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                element.setId(resultSet.getLong(1));
            }
            return element;
        } catch (SQLException ex) {
            throw new DataProcessingException("Created product " + element + " is failed!", ex);
        }
    }

    @Override
    public Optional<Product> getById(Long id) {
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(QUERY_GET_ID);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("product_name");
                double price = resultSet.getDouble("price");
                Product product = new Product(id, name, price);
                return Optional.of(product);
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new DataProcessingException("Delete of product with id = " + id + " is failed!", e);
        }
    }

    @Override
    public Product update(Product element) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(QUERY_DELETE);
            statement.setLong(1, id);
            statement.executeQuery();
            return true;
        } catch (SQLException e) {
            throw new DataProcessingException("Delete of product with id = " + id + " is failed!", e);
        }
    }

    @Override
    public List<Product> getAll() {
        return null;
    }
}
