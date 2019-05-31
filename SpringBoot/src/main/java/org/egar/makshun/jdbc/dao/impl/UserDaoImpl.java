package org.egar.makshun.jdbc.dao.impl;

import org.egar.makshun.jdbc.dao.UserDao;
import org.egar.makshun.jdbc.jdbc.MySqlQuery;
import org.egar.makshun.jdbc.mapper.UserRowMapper;
import org.egar.makshun.jdbc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class UserDaoImpl implements UserDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User getOne(Long userId) {
        String query = MySqlQuery.getInstance().getQuery("queryGetUserById");
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        return jdbcTemplate.queryForObject(query, rowMapper, userId);
    }

    @Override
    public List<User> findAllUsers() {
        String query = MySqlQuery.getInstance().getQuery("queryFindAllUsers");
        RowMapper<User> rowMapper = new UserRowMapper();
        return this.jdbcTemplate.query(query, rowMapper);
    }

    @Override
    public List<User> findAllUsersByRole(String roleName) {
        String query = MySqlQuery.getInstance().getQuery("queryFindAllUsersByRole");
        RowMapper<User> rowMapper = new UserRowMapper();
        return this.jdbcTemplate.query(query, rowMapper, roleName);
    }

    @Override
    public User save(User user) {
        String query = user.getId() != null ?
                MySqlQuery.getInstance().getQuery("updateUser") :
                MySqlQuery.getInstance().getQuery("insertUser");
        if (user.getId() != null) {
            jdbcTemplate.update(query, user.getLogin(), user.getPassword(), user.getId());
            return user;
        } else {
            jdbcTemplate.update(query, user.getLogin(), user.getPassword());
            query = MySqlQuery.getInstance().getQuery("queryGetIdByLoginAndPassword");
            Long userId = jdbcTemplate.queryForObject(query, Long.class, user.getLogin(), user.getPassword());
            user.setId(userId);
            return user;
        }
    }

    @Override
    public void remove(Long userId) {
        String query = MySqlQuery.getInstance().getQuery("deleteUser");
        jdbcTemplate.update(query, userId);
    }

}
