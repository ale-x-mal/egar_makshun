package org.egar.makshun.jdbc.service.impl;

import org.egar.makshun.jdbc.dao.UserDao;
import org.egar.makshun.jdbc.model.User;
import org.egar.makshun.jdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getOne(Long userId) {
        return userDao.getOne(userId);
    }

    @Override
    public List<User> findAllUsers() {
        return userDao.findAllUsers();
    }

    @Override
    public List<User> findAllUsersByRole(String roleName) {
        return userDao.findAllUsersByRole(roleName);
    }

    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    public void remove(Long userId) {
        if (userId != 1) {
            userDao.remove(userId);
        }
    }


}
