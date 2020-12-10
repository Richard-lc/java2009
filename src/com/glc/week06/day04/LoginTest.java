package com.glc.week06.day04;

import com.glc.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author Richard
 * 2020/12/10 11:41
 */
public class LoginTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("==========登录===========");
        System.out.println("请输入用户名：");
        String username = sc.next();
        System.out.println("请输入密码：");
        String password = sc.next();
        User user = login(username, password);
        if (user != null) {
            System.out.println("登录成功！欢迎你" + user.getUsername() + "~");
        } else {
            System.out.println("用户名与密码不匹配！");
        }
    }

    private static User login(String username, String password) {
        DBUtils dbUtils = new DBUtils();
        Connection conn = dbUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String str = "select * from user where username = ? and password = ?";
        try {
            ps = conn.prepareStatement(str);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            dbUtils.close();
        }
        return null;
    }
}
