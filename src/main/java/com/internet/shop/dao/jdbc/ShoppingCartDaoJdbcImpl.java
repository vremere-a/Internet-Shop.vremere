package com.internet.shop.dao.jdbc;

import com.internet.shop.dao.interfaces.ShoppingCartDao;
import com.internet.shop.exeptions.DataProcessingException;
import com.internet.shop.library.Dao;
import com.internet.shop.model.Product;
import com.internet.shop.model.ShoppingCart;
import com.internet.shop.util.ConnectionUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Dao
public class ShoppingCartDaoJdbcImpl implements ShoppingCartDao {
    @Override
    public Optional<ShoppingCart> getByUserId(Long userId) {
        ShoppingCart shoppingCart = new ShoppingCart();
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM shopping_carts WHERE user_id = ?");
            statement.setLong(1, userId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                shoppingCart = getCartFromResultSet(resultSet);
            }
        } catch (SQLException ex) {
            throw new DataProcessingException("Can't get product by " + userId + " !", ex);
        }
        shoppingCart.setProducts(getProductsFromCart(shoppingCart.getId()));
        return Optional.of(shoppingCart);
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
        ShoppingCart shoppingCart = new ShoppingCart();
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM shopping_carts WHERE cart_id = ?");
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
        insertProductsToCart(cart);
        return cart;
        }

    @Override
    public boolean deleteById(Long id) {
        String query = "DELETE FROM shopping_carts WHERE cart_id=?";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, id);
            return statement.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't delete cart ", e);
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
        return new ShoppingCart(userId, cartId);
    }

    private List<Product> getProductsFromCart(Long cartId) {
        String query = "SELECT * FROM shopping_carts_products "
                + "INNER JOIN products "
                + "ON shopping_carts_products.product_id = products.product_id "
                + "WHERE shopping_carts_products.cart_id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, cartId);
            ResultSet resultSet = statement.executeQuery();
            List<Product> products = new ArrayList<>();
            while (resultSet.next()) {
                Long productId = resultSet.getLong("product_id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                products.add(new Product(productId, name, price));
            }
            return products;
        } catch (SQLException e) {
            throw new DataProcessingException("Couldn't get shopping cart products with ID = "
                    + cartId, e);
        }
    }

    private Product getProductFromResultSet(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong("product_id");
        String name = resultSet.getString("product_name");
        double price = resultSet.getDouble("price");
        return new Product(id, name, price);
    }

    private List<Product> getAllProductsFromCart(Long cartId) {
        Product product;
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM shopping_carts_products " +
                "INNER JOIN products " +
                "ON shopping_carts_products.product_id = products.product_id " +
                "WHERE shopping_carts_products.order_id = ?";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement =
                    connection.prepareStatement(query);
            statement.setLong(1, cartId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                product = getProductFromResultSet(resultSet);
                products.add(product);
            }
            return products;
        } catch (SQLException ex) {
            throw new DataProcessingException("Can't get products by " + cartId + " !", ex);
        }
    }

    private ShoppingCart insertProductsToCart(ShoppingCart cart) {
        String queryToUpdateProducts = "INSERT INTO shopping_carts_products(cart_id, product_id) "
                + "VALUES(?, ?);";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(queryToUpdateProducts)) {
            statement.setLong(1, cart.getId());
            for (Product product : cart.getProducts()) {
                statement.setLong(2, product.getId());
                statement.executeUpdate();
            }
            return cart;
        } catch (SQLException e) {
            throw new DataProcessingException("Couldn't update shopping cart - " + cart, e);
        }
    }
}
