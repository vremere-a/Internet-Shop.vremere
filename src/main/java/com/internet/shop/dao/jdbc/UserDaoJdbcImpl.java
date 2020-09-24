package com.internet.shop.dao.jdbc;

import com.internet.shop.dao.interfaces.UserDao;
import com.internet.shop.exeptions.DataProcessingException;
import com.internet.shop.library.Dao;
import com.internet.shop.model.Role;
import com.internet.shop.model.User;
import com.internet.shop.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Dao
public class UserDaoJdbcImpl implements UserDao {

    @Override
    public Optional<User> findByLogin(String login) {
        User user = new User();
        String query = "SELECT * FROM users WHERE login = ? AND deleted = false";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = getUserFromResultSet(resultSet);
            }
        } catch (SQLException ex) {
            throw new DataProcessingException("Can't get user by " + login + " !", ex);
        }
        user.setRoles(getRolesOfUser(user.getId()));
        return Optional.ofNullable(user);
    }

    @Override
    public User create(User user) {
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO users(user_name, user_surname, email, login, password)\n"
                            + "VALUE (?, ?, ?, ?, ?);",
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
        } catch (SQLException ex) {
            throw new DataProcessingException("Can't create user " + user + " !", ex);
        }
        return insertRoleToUser(user);
    }

    @Override
    public Optional<User> getById(Long id) {
        User user = new User();
        String query = "SELECT * FROM users \n"
                + "INNER JOIN users_roles \n"
                + "ON users.user_id = users_roles.user_id \n"
                + "WHERE users.user_id = ? AND deleted = false";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = getUserFromResultSet(resultSet);
            }
        } catch (SQLException ex) {
            throw new DataProcessingException("Can't get user by " + id + " !", ex);
        }
        user.setRoles(getRolesOfUser(user.getId()));
        return Optional.ofNullable(user);
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
                            + " WHERE user_id = ?");
            statement.setLong(1, id);
            int updates = statement.executeUpdate();
            return updates > 0;
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
        String query = "INSERT INTO users_roles (user_id, role_id) "
                + "values (?, (SELECT role_id FROM roles WHERE role_name = ?))";
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
        user.setRoles(getRolesOfUser(user.getId()));
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

    private Set<Role> getRolesOfUser(Long userId) {
        String query = "SELECT roles.role_id, role_name FROM roles  INNER JOIN users_roles "
                + "ON users_roles.role_id = roles.role_id WHERE users_roles.user_id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, userId);
            ResultSet rs = statement.executeQuery();
            Set<Role> roles = new HashSet<>();
            while (rs.next()) {
                Long roleId = rs.getLong("role_id");
                String roleName = rs.getString("role_name");
                Role role = Role.of(roleName);
                role.setId(roleId);
                roles.add(role);
            }
            return roles;
        } catch (SQLException e) {
            throw new DataProcessingException("Couldn't get roles of user with ID = "
                    + userId, e);
        }
    }
}
