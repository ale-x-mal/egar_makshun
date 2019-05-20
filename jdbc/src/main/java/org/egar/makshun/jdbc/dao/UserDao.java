package org.egar.makshun.jdbc.dao;

import org.egar.makshun.jdbc.model.User;

import java.util.List;

public interface UserDao {

    User getOne(Long userId);

    List<User> findAllUsers();

    List<User> findAllUsersByRole(String roleName);

    User save(User user);

    void remove(Long userId);

    String runFunction();
}
