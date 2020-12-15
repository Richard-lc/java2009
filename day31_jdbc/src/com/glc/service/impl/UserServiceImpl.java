package com.glc.service.impl;

import com.glc.dao.IUserDao;
import com.glc.dao.impl.UserDaoImpl;
import com.glc.entity.User;
import com.glc.service.IUserService;

import java.util.List;

/**
 * @author Richard
 * 2020/12/15 11:01
 */
public class UserServiceImpl implements IUserService {

    IUserDao userDao;

    public UserServiceImpl() {
        this.userDao = new UserDaoImpl();
    }

    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public int deleteUserByUserName(String username) {
        return userDao.deleteUser(username);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public List<User> getUserList() {
        return userDao.getUserList();
    }

    @Override
    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    @Override
    public User login(String username, String password) {

        User user = userDao.getUserByUsername(username);

        if (user != null) {
            if (user.getPassword().equals(password)) {
                return user;
            }
        }

        return null;
    }


}
