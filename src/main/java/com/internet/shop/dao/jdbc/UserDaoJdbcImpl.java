package com.internet.shop.dao.jdbc;

import com.internet.shop.dao.interfaces.UserDao;
import com.internet.shop.exeptions.DataProcessingException;
import com.internet.shop.library.Dao;
import com.internet.shop.model.Order;
import com.internet.shop.model.Role;
import com.internet.shop.model.User;
import com.internet.shop.util.ConnectionUtil;

import java.sql.*;
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
        return Optional.empty();
    }

    @Override
    public User update(User element) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public List<User> getAll() {
        return null;
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

}
