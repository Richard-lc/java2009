package com.glc.week07.day01.login.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Richard
 * 2020/12/14 13:20
 */
public class DBUtils {

    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    static {
        Properties properties = new Properties();
        try {
            properties.load(DBUtils.class.getClassLoader().getResourceAsStream("./db.properties"));
            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接
     *
     * @return 数据库连接
     */
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 关闭资源
     *
     * @param args 需要关闭的对象
     */
    public static void close(AutoCloseable... args) {
        for (AutoCloseable arg : args) {
            if (arg != null) {
                try {
                    arg.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
