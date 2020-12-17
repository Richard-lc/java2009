package utils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Richard
 * 2020/12/16 11:25
 */
public class DaoUtils {

    /**
     * 公共的更新方法
     *
     * @param sql  预处理的sql语句
     * @param args 占位符参数
     * @return 受影响的行数
     */
    public static int commonUpdate(String sql, Object... args) {
        Connection connection = DBUtils.getConnection();
        PreparedStatement prst = null;
        try {
            prst = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                prst.setObject(i + 1, args[i]);
            }
            return prst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(prst);
        }
        return 0;
    }

    /**
     * 公共的查询方法
     *
     * @param sql  预处理的sql语句
     * @param cls  需要封装的实体类
     * @param args 占位符参数
     * @param <T>  实体类类型
     * @return 实体集合List<T>
     */
    public static <T> List<T> commonQuery(String sql, Class<T> cls, Object... args) {
        Connection connection = DBUtils.getConnection();
        List<T> list = new ArrayList<>();
        PreparedStatement prst = null;
        try {
            prst = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                prst.setObject(i + 1, args[i]);
            }
            ResultSet rs = prst.executeQuery();
            Field[] fields = cls.getDeclaredFields();

            while (rs.next()) {
                try {
                    T t = cls.newInstance();
                    for (int i = 0; i < fields.length; i++) {
                        String filedName = fields[i].getName();
                        Object value;
                        try {
                            //字段名不一致，会出现异常
                            value = rs.getObject(filedName);
                        } catch (SQLException e) {
                            //到配置文件中查找对应字段
                            String colName = DBUtils.getProperties().getProperty(filedName);
                            //根据对应字段获取数据
                            value = rs.getObject(colName);
                        }
                        fields[i].setAccessible(true);
                        fields[i].set(t, value);
                    }
                    list.add(t);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(prst, connection);
        }
        return list;
    }
}
