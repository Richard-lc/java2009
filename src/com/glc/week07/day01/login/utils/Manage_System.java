package com.glc.week07.day01.login.utils;

import com.glc.week07.day01.login.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Richard
 * 2020/12/14 13:48
 */
public class Manage_System {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("=========学生管理系统v1.0=============");
        while (true) {
            System.out.println("1.新增学生  2.修改学生  3.删除学生  4.查询学生  5.退出");
            Integer num = checkNum();//判断输入是否合法
            switch (num) {
                case 1:
                    addUser();//新增用户
                    break;
                case 2:
                    updateUser();//修改用户
                    break;
                case 3:
                    deleteUser();//删除用户
                    break;
                case 4:
                    getUserList();//查询用户
                    break;
                case 5:
                    System.out.println("谢谢使用，再见~");
                    return;
            }
        }
    }

    /**
     * 删除用户
     */
    private static void deleteUser() {
        System.out.println("请输入要删除的用户名：");
        String username = scanner.next();
        User checkUser = getUserByUsername(username);
        if (checkUser == null) {
            System.out.println("【" + username + "】" + "用户不存在！");
            return;
        }

        Connection connection = DBUtils.getConnection();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("delete from user where username = ?");
            ps.setString(1, username);
            int i = ps.executeUpdate();
            if (i != 0) {
                System.out.println("删除成功！");
            } else {
                System.out.println("删除失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(ps, connection);
        }

    }

    /**
     * 修改用户
     */
    private static void updateUser() {
        System.out.println("请输入要修改的用户名：");
        String username = scanner.next();
        User checkUser = getUserByUsername(username);
        if (checkUser == null) {
            System.out.println("【" + username + "】" + "用户不存在！");
            return;
        }

        User user = inputInfo();
        user.setUserName(username);
        System.out.println(user);

        Connection connection = DBUtils.getConnection();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("update user set password = ?,age = ?,sex = ? where username = ?");
            ps.setString(1, user.getPassword());
            ps.setInt(2, user.getAge());
            ps.setInt(3, user.getSex());
            ps.setString(4, user.getUserName());
            int i = ps.executeUpdate();
            if (i != 0) {
                System.out.println("修改成功！");
            } else {
                System.out.println("修改失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(ps, connection);
        }

    }

    /**
     * 控制台录入信息
     *
     * @return 返回封装后的user对象
     */
    private static User inputInfo() {
        System.out.println("请输入密码：");
        String password = scanner.next();
        System.out.println("请输入年龄：");
        Integer age = scanner.nextInt();
        System.out.println("请输入性别：");
        Integer sex = scanner.nextInt();

        User user = new User();
        user.setPassword(password);
        user.setAge(age);
        user.setSex(sex);
        return user;
    }

    /**
     * 新增用户
     */
    private static void addUser() {
        System.out.println("请输入用户名：");
        String username = scanner.next();
        User checkUser = getUserByUsername(username);
        if (checkUser != null) {
            System.out.println("【" + username + "】" + "用户已存在！");
            return;
        }

        User user = inputInfo();
        user.setUserName(username);

        Connection connection = DBUtils.getConnection();
        PreparedStatement prst = null;
        try {
            prst = connection.prepareStatement("insert into user(username,password,age,sex) values(?,?,?,?)");
            prst.setString(1, user.getUserName());
            prst.setString(2, user.getPassword());
            prst.setInt(3, user.getAge());
            prst.setInt(4, user.getSex());

            int i = prst.executeUpdate();

            if (i != 0) {
                System.out.println("添加成功！");
            } else {
                System.out.println("添加失败！");
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(prst, connection);
        }
    }

    /**
     * 判断输入的数字是否合法
     *
     * @return 返回输入的数字
     */
    private static Integer checkNum() {
        Integer num = 0;
        while (true) {
            System.out.println("请输入你的操作：");
            try {
                num = Integer.parseInt(scanner.next());
            } catch (NumberFormatException e) {
                System.err.println("输入有误，请重新输入！");
                continue;
            }
            if (num < 1 || num > 5) {
                System.err.println("请输入数字1-5！");
                continue;
            } else {
                return num;
            }
        }
    }

    /**
     * 查询所有用户
     */
    public static void getUserList() {
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
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(connection, prst, rs);
        }

        for (User u : list) {
            System.out.println(u);
        }
        return;
    }

    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return 返回查询到的user对象
     */
    private static User getUserByUsername(String username) {
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
