package com.internet.shop.dao.jdbc;

import com.internet.shop.dao.interfaces.ShoppingCartDao;
import com.internet.shop.exeptions.DataProcessingException;
import com.internet.shop.library.Dao;
import com.internet.shop.model.Product;
import com.internet.shop.model.ShoppingCart;
import com.internet.shop.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Dao
public class ShoppingCartDaoJdbcImpl implements ShoppingCartDao {
    @Override
    public Optional<ShoppingCart> getByUserId(Long userId) {
        ShoppingCart shoppingCart = null;
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM shopping_carts WHERE user_id = ? AND deleted = false");
            statement.setLong(1, userId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                shoppingCart = getCartFromResultSet(resultSet);
            }
        } catch (SQLException ex) {
            throw new DataProcessingException("Can't get product by " + userId + " !", ex);
        }
        if (shoppingCart != null) {
            shoppingCart.setProducts(getProductsFromCart(shoppingCart.getId()));
        }
        return Optional.ofNullable(shoppingCart);
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
            throw new DataProcessingException("Can't create " + cart, e);
        }
    }

    @Override
    public Optional<ShoppingCart> getById(Long id) {
        ShoppingCart shoppingCart = new ShoppingCart();
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM shopping_carts WHERE cart_id = ? AND deleted = false");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                shoppingCart = getCartFromResultSet(resultSet);
            }
        } catch (SQLException ex) {
            throw new DataProcessingException("Can't get product by " + id + " !", ex);
        }
        shoppingCart.setProducts(getProductsFromCart(shoppingCart.getId()));
        return Optional.of(shoppingCart);
    }

    @Override
    public ShoppingCart update(ShoppingCart cart) {
        String queryToDeleteProducts = "DELETE FROM shopping_carts_products WHERE cart_id = ?;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(queryToDeleteProducts)) {
            statement.setLong(1, cart.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DataProcessingException("Couldn't delete products from shopping cart - "
                    + cart, e);
        }
        addProductsToCart(cart);
        return cart;
    }

    @Override
    public boolean deleteById(Long id) {
        String query = "UPDATE shopping_carts SET deleted = true WHERE cart_id = ?";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, id);
            int updates = statement.executeUpdate();
            return updates > 0;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't delete cart " + id, e);
        }
    }

    @Override
    public List<ShoppingCart> getAll() {
        List<ShoppingCart> shoppingCarts = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement =
                    connection.prepareStatement("SELECT * FROM shopping_carts");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ShoppingCart shoppingCart = getCartFromResultSet(resultSet);
                shoppingCarts.add(shoppingCart);
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Get all carts is failed!", e);
        }
        return shoppingCarts;
    }

    private ShoppingCart getCartFromResultSet(ResultSet resultSet) throws SQLException {
        Long cartId = resultSet.getLong("cart_id");
        Long userId = resultSet.getLong("user_id");
        return new ShoppingCart(cartId, userId);
    }

    private List<Product> getProductsFromCart(Long cartId) {
        String query = "SELECT * FROM shopping_carts_products cp "
                + "INNER JOIN products p "
                + "ON cp.product_id = p.product_id "
                + "WHERE cp.cart_id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, cartId);
            ResultSet resultSet = statement.executeQuery();
            List<Product> products = new ArrayList<>();
            while (resultSet.next()) {
                Long productId = resultSet.getLong("product_id");
                String name = resultSet.getString("product_name");
                double price = resultSet.getDouble("price");
                products.add(new Product(productId, name, price));
            }
            return products;
        } catch (SQLException e) {
            throw new DataProcessingException("Couldn't get shopping cart products with ID = "
                    + cartId, e);
        }
    }

    private ShoppingCart addProductsToCart(ShoppingCart cart) {
        String query = "INSERT INTO shopping_carts_products(cart_id, product_id) "
                + "VALUES(?, ?);";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)) {
            for (Product product : cart.getProducts()) {
                statement.setLong(1, cart.getId());
                statement.setLong(2, product.getId());
                statement.executeUpdate();
            }
            return cart;
        } catch (SQLException e) {
            throw new DataProcessingException("Couldn't update shopping cart - " + cart, e);
        }
    }
}
