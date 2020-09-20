package com.internet.shop.dao.jdbc;

import com.internet.shop.dao.interfaces.ProductDao;
import com.internet.shop.model.Product;
import com.internet.shop.util.ConnectionUtil;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class ProductDaoJdbcImpl implements ProductDao {
    String query =
            "INSERT INTO products (productName, price) VALUES (?, ?)";
    @Override
    public Product create(Product element) {

        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection
                    .prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                element.setId(resultSet.getLong(1));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return element;
    }

    @Override
    public Optional<Product> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public Product update(Product element) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public List<Product> getAll() {
        return null;
    }
}
