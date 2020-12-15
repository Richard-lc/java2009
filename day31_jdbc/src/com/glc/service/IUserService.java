package com.glc.service;

import com.glc.entity.User;

import java.util.List;

/**
 * @author Richard
 * 2020/12/15 10:59
 */
public interface IUserService {
    /**
     * 添加用户
     *
     * @param user 要添加的user对象
     * @return 受影响的行数
     */
    int addUser(User user);

    /**
     * 删除用户
     *
     * @param username 要删除的用户名
     * @return 受影响的行数
     */
    int deleteUserByUserName(String username);

    /**
     * 更新用户信息
     *
     * @param user 要更新的user对象
     * @return 受影响的行数
     */
    int updateUser(User user);

    /**
     * 查询所有用户信息
     *
     * @return 所有用户的List集合
     */
    List<User> getUserList();

    /**
     * 根据用户名查询用户信息
     *
     * @param username 要查询的用户名
     * @return 查询到的用户信息
     */
    User getUserByUsername(String username);

    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 登录成功的User对象
     */
    User login(String username, String password);

}
