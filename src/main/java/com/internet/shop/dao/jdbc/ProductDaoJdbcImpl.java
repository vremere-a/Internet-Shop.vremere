package com.internet.shop.dao.jdbc;

import com.internet.shop.dao.interfaces.ProductDao;
import com.internet.shop.exeptions.DataProcessingException;
import com.internet.shop.model.Product;
import com.internet.shop.util.ConnectionUtil;
import java.sql.*;
import java.util.ArrayList;
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
    public Product create(Product product) {

        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection
                    .prepareStatement(QUERY_CREATE, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.executeQuery();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                product.setId(resultSet.getLong(1));
            }
            return product;
        } catch (SQLException ex) {
            throw new DataProcessingException("Created product " + product + " is failed!", ex);
        }
    }

    @Override
    public Optional<Product> getById(Long id) {
        Product product;
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(QUERY_GET_ID);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                product = getProductFromResultSet(resultSet);
                return Optional.of(product);
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new DataProcessingException("Get product by id = " + id + " is failed!", e);
        }
    }

    @Override
    public Product update(Product product) {
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(QUERY_UPDATE);
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setLong(3, product.getId());
            statement.executeUpdate();
            return product;
        } catch (SQLException e) {
            throw new DataProcessingException("Product update with id is failed!", e);
        }
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
        List<Product> products = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(QUERY_GET_ALL);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Product product = getProductFromResultSet(resultSet);
                products.add(product);
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Get all products is failed!", e);
        }
        return products;
    }

    private Product getProductFromResultSet(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong("product_id");
        String name = resultSet.getString("product_name");
        double price = resultSet.getDouble("price");
        return new Product(id, name, price);
    }
}
