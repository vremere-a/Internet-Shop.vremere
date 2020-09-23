package com.internet.shop.dao.jdbc;

import com.internet.shop.dao.interfaces.UserDao;
import com.internet.shop.exeptions.DataProcessingException;
import com.internet.shop.library.Dao;
import com.internet.shop.model.Order;
import com.internet.shop.model.Product;
import com.internet.shop.model.Role;
import com.internet.shop.model.User;
import com.internet.shop.util.ConnectionUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Dao
public class UserDaoJdbcImpl implements UserDao {

    @Override
    public Optional<User> findByLogin(String login) {
        return Optional.empty();
    }

    @Override
    public User create(User user) {
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO users(user_name, user_surname, email, login, password)\n" +
                            "VALUE (?, ?, ?, ?, ?);",
                    Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getName());
            statement.setString(2, user.getSurname());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getLogin());
            statement.setString(5, user.getPassword());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                user.setId(resultSet.getLong(1));
            }
            return insertRoleToUser(user);
        } catch (SQLException ex) {
            throw new DataProcessingException("Can't create user " + user + " !", ex);
        }
    }

    @Override
    public Optional<User> getById(Long id) {
        String query = "SELECT * FROM users WHERE user_id = ? AND deleted = false";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(getUserFromResultSet(resultSet));
            }
        } catch (SQLException ex) {
            throw new DataProcessingException("Can't get user by " + id + " !", ex);
        }
        return Optional.empty();
    }

    @Override
    public User update(User user) {
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE users SET user_name = ?,"
                            + " user_surname = ?, email = ?, login = ?, password = ? "
                            + "WHERE user_id = ? AND deleted = false");
            statement.setString(1, user.getName());
            statement.setString(2, user.getSurname());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getLogin());
            statement.setString(5, user.getPassword());
            statement.setLong(6, user.getId());
            statement.executeUpdate();
            return user;
        } catch (SQLException e) {
            throw new DataProcessingException("User update with "
                    + user.getId() + "id is failed!", e);
        }
    }

    @Override
    public boolean deleteById(Long id) {
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE users SET deleted = true"
                            + " WHERE user_id = ? AND deleted = false");
            statement.setLong(1, id);
            return statement.executeUpdate() == 1;
        } catch (SQLException ex) {
            throw new DataProcessingException("Can't delete user with id = " + id + " !", ex);
        }
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement =
                    connection.prepareStatement("SELECT * FROM users \n"
                            + "INNER JOIN users_roles\n"
                            + "ON users.user_id = users_roles.user_id\n"
                            + "WHERE deleted = false;");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = getUserFromResultSet(resultSet);
                users.add(user);
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Get all users is failed!", e);
        }
        return users;
    }

    private User insertRoleToUser(User user) {
        String query = "INSERT INTO users_roles (user_id, role_id) " +
                "values (?, (SELECT role_id FROM roles WHERE role_name = ?))";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement =
                    connection.prepareStatement(query);
            for (Role r : user.getRoles()) {
                statement.setLong(1, user.getId());
                statement.setString(2, r.getRoleName().name());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new DataProcessingException("insert role to User is failed!", e);
        }

        return user;
    }

    private User getUserFromResultSet(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong("user_id");
        String name = resultSet.getString("user_name");
        String surName = resultSet.getString("user_surname");
        String email = resultSet.getString("email");
        String login = resultSet.getString("login");
        String password = resultSet.getString("password");
        return new User(id, name, surName, email, login, password);
    }

}
