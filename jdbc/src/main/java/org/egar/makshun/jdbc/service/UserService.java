package org.egar.makshun.jdbc.service;

import org.egar.makshun.jdbc.model.User;

import java.util.List;

public interface UserService {

    User getOne(Long userId);

    List<User> findAllUsers();

    List<User> findAllUsersByRole(String roleName);

    User save(User user);

    void remove(Long userId);

    String runFunction();

}
