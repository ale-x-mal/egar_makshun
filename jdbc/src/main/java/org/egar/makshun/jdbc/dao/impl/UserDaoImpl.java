package org.egar.makshun.jdbc.dao.impl;

import org.egar.makshun.jdbc.dao.UserDao;
import org.egar.makshun.jdbc.jdbc.MySqlConnector;
import org.egar.makshun.jdbc.jdbc.MySqlQuery;
import org.egar.makshun.jdbc.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private Connection connection = MySqlConnector.getInstance().getConnection();


    @Override
    public User getOne(Long userId) {
        String query = MySqlQuery.getInstance().getQuery("queryGetUserById");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, userId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return User
                        .builder()
                        .id(resultSet.getLong(1))
                        .login(resultSet.getString(2))
                        .password(resultSet.getString(3))
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            close(preparedStatement, resultSet);
        }
        return null;
    }

    @Override
    public List<User> findAllUsers() {
        String query = MySqlQuery.getInstance().getQuery("queryFindAllUsers");
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            List<User> usersList = new ArrayList<>();
            while (resultSet.next()) {
                usersList.add(
                        User
                                .builder()
                                .id(resultSet.getLong(1))
                                .login(resultSet.getString(2))
                                .password(resultSet.getString(3))
                                .build()
                );
            }
            return usersList;
        } catch (SQLException e) {
            e.printStackTrace();
            close(statement, resultSet);
        }
        return new ArrayList<>(0);
    }

    @Override
    public List<User> findAllUsersByRole(String roleName) {
        String query = MySqlQuery.getInstance().getQuery("queryFindAllUsersByRole");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, roleName);
            resultSet = preparedStatement.executeQuery();
            List<User> usersList = new ArrayList<>();
            while (resultSet.next()) {
                usersList.add(
                        User
                                .builder()
                                .id(resultSet.getLong(1))
                                .login(resultSet.getString(2))
                                .password(resultSet.getString(3))
                                .build()
                );
            }
            return usersList;
        } catch (SQLException e) {
            e.printStackTrace();
            close(preparedStatement, resultSet);
        }
        return new ArrayList<>(0);
    }

    @Override
    public User save(User user) {
        PreparedStatement preparedStatement = null;
        String query = user.getId() != null ?
                MySqlQuery.getInstance().getQuery("updateUser") :
                MySqlQuery.getInstance().getQuery("insertUser");
        try {
            preparedStatement = user.getId() != null ?
                    connection.prepareStatement(query) :
                    connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            if (user.getId() != null) {
                preparedStatement.setLong(3, user.getId());
                return preparedStatement.executeUpdate() > 0 ? user : null;
            } else {
                preparedStatement.executeUpdate();
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next()) {
                    user.setId(resultSet.getLong(1));
                    resultSet.close();
                    return user;
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            close(preparedStatement, null);
        }
        return null;
    }

    @Override
    public void remove(Long userId) {

        String query = MySqlQuery.getInstance().getQuery("deleteUser");
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, userId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            close(preparedStatement, null);
        }
    }

    public String runFunction() {
        CallableStatement callableStatement = null;
        try {
            callableStatement = connection.prepareCall(" { ? = call testFunction() } ");
            ResultSet resultSet = callableStatement.executeQuery();
            resultSet.next();
            return resultSet.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
            close(callableStatement, null);
        }
        return null;
    }

    private void close(Statement statement, ResultSet resultSet) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
