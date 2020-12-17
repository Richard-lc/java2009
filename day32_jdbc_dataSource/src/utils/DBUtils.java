package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Richard
 * 2020/12/14 13:20
 */
public class DBUtils {

    //声名DataSource对象
    private static DataSource dataSource;
    private static Properties properties;

    //使用ThreadLocal管理连接对象
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    /**
     *  Properties只需要加载一次
     */
    static {
        properties = new Properties();
        try {
            properties.load(DBUtils.class.getClassLoader().getResourceAsStream("./db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            //创建连接池
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接
     *
     * @return 数据库连接
     */
    public static Connection getConnection() {
        Connection connection = threadLocal.get();
        try {
            if (connection == null) {
                //从连接池中获取连接
                connection = dataSource.getConnection();
                threadLocal.set(connection);
            }
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
                    if (arg instanceof Connection) {
                        threadLocal.remove();
                    }
                    arg.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 开启事务
     */
    public static void beginTransaction() {
        Connection connection = getConnection();
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 提交事务
     */
    public static void commit() {
        Connection connection = getConnection();
        try {
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }
    }

    /**
     * 回滚事务
     */
    public static void rollback() {
        Connection connection = getConnection();
        try {
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }
    }

    public static Properties getProperties() {
        return properties;
    }
}
