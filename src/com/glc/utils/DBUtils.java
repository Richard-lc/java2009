package com.glc.utils;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author Richard
 * 2020/12/10 9:58
 */
public class DBUtils {

    public Connection conn;
    private Statement st;
    private PreparedStatement ps;
    private ResultSet rs;
    private int result;

    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    static {
        Properties properties = new Properties();
        try {
            //加载配置文件
            properties.load(DBUtils.class.getClassLoader().getResourceAsStream("db.properties"));
            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            //加载驱动
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public DBUtils() {
        this.conn = getConnection();
    }

    //获取连接
    public Connection getConnection() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    //insert,delete,update
    public int execute(String sql) {
        try {
            st = conn.createStatement();
            result = st.executeUpdate(sql);
            System.out.println(result + "条记录受影响");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    //查询
    public ResultSet getResultSet(String sql) {
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    //根据id查询
    public ResultSet getRsById(String table, Integer id) {
        ResultSet rs = null;
        try {
            String sql = "select * from " + table + " where id = ?;";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    //关闭资源
    public void close() {
        try {
            if (conn != null) {
                conn.close();
            }
            if (st != null) {
                st.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close(AutoCloseable... ac) {
        for (AutoCloseable closeable : ac) {
            if (ac != null) {
                try {
                    closeable.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
