package com.glc.week06.day03.utils;

import java.sql.*;

/**
 * JDBC工具类
 *
 * @author Richard
 * 2020/12/9 16:44
 */
public class DBUtils {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获得连接对象
        String url = "jdbc:mysql://localhost:3306/mydb1";
        String user = "root";
        String password = "gong123456";
        Connection conn = DriverManager.getConnection(url, user, password);
        //3.获得执行SQL语句的对象
        String sql = "select * from user;";
        Statement s = conn.createStatement();
        //4.执行SQL语句，并接收结果
        ResultSet rs = s.executeQuery(sql);
        //5.处理结果
        System.out.println("id \t用户名 \t密码 \t地址 \t\t电话号码");
        while (rs.next()) {
            System.out.print(rs.getInt("userId") + " \t");
            System.out.print(rs.getString("username") + " \t");
            System.out.print(rs.getString("password") + " \t");
            System.out.print(rs.getString("address") + " \t");
            System.out.print(rs.getString("phone"));
            System.out.println();
        }
        //6.释放资源
        s.close();
        conn.close();
    }
}
