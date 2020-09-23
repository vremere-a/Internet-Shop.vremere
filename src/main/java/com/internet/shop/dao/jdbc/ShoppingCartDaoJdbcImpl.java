package com.internet.shop.dao.jdbc;

import com.internet.shop.dao.interfaces.ShoppingCartDao;
import com.internet.shop.exeptions.DataProcessingException;
import com.internet.shop.library.Dao;
import com.internet.shop.model.ShoppingCart;
import com.internet.shop.util.ConnectionUtil;

import java.sql.*;
import java.util.List;
import java.util.Optional;

@Dao
public class ShoppingCartDaoJdbcImpl implements ShoppingCartDao {
    @Override
    public Optional<ShoppingCart> getByUserId(Long userId) {
        return Optional.empty();
    }

    @Override
    public ShoppingCart create(ShoppingCart cart) {
         String query = "INSERT INTO shopping_carts(user_id) VALUES(?)";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement =
                    connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, cart.getUserId());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                cart.setId(resultSet.getLong(1));
            }
            return cart;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't create cart" + cart, e);
        }
    }

    @Override
    public Optional<ShoppingCart> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public ShoppingCart update(ShoppingCart element) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public List<ShoppingCart> getAll() {
        return null;
    }
}
