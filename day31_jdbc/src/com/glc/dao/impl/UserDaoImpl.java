package com.glc.dao.impl;

import com.glc.dao.IUserDao;
import com.glc.entity.User;
import com.glc.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Richard
 * 2020/12/14 19:18
 */
public class UserDaoImpl implements IUserDao {
    @Override
    public int addUser(User user) {
        Connection connection = DBUtils.getConnection();
        PreparedStatement prst = null;
        try {
            prst = connection.prepareStatement("insert into user(username,password,age,sex) values(?,?,?,?)");
            prst.setString(1, user.getUserName());
            prst.setString(2, user.getPassword());
            prst.setInt(3, user.getAge());
            prst.setInt(4, user.getSex());
            return prst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(prst, connection);
        }
        return 0;
    }

    @Override
    public int deleteUser(String username) {
        Connection connection = DBUtils.getConnection();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("delete from user where username = ?");
            ps.setString(1, username);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(ps, connection);
        }
        return 0;
    }

    @Override
    public int updateUser(User user) {
        Connection connection = DBUtils.getConnection();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("update user set password = ?,age = ?,sex = ? where username = ?");
            ps.setString(1, user.getPassword());
            ps.setInt(2, user.getAge());
            ps.setInt(3, user.getSex());
            ps.setString(4, user.getUserName());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(ps, connection);
        }
        return 0;
    }

    @Override
    public List<User> getUserList() {
        Connection connection = DBUtils.getConnection();
        List<User> list = new ArrayList<>();
        PreparedStatement prst = null;
        ResultSet rs = null;
        try {
            prst = connection.prepareStatement("select * from user");
            rs = prst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                int age = rs.getInt("age");
                int sex = rs.getInt("sex");

                User user = new User(id, username, password, age, sex);
                list.add(user);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(connection, prst, rs);
        }
        return null;
    }

    @Override
    public User getUserByUsername(String username) {
        Connection connection = DBUtils.getConnection();
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("select * from user where username = ?");
            ps.setString(1, username);

            rs = ps.executeQuery();

            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setAge(rs.getInt("age"));
                user.setSex(rs.getInt("sex"));

                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(rs, ps, connection);
        }
        return null;
    }
}
