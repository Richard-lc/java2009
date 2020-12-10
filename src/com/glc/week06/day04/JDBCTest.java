package com.glc.week06.day04;

import com.glc.utils.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Richard
 * 2020/12/10 10:24
 */
public class JDBCTest {

    public static void main(String[] args) {
        DBUtils dbUtils = new DBUtils();
//        Connection conn = dbUtils.getConnection();
//        String str = "delete from account where id = 4;";
////        String str = "insert into account values(4,'ww',500)";
//        dbUtils.execute(str);
//
//        ResultSet rs = dbUtils.getResultSet("select * from account");
//        System.out.println(rs);
//        dbUtils.close();
        ResultSet rs = dbUtils.getRsById("account", 1);
        try {
            if (rs.next()) {

                System.out.println(rs.getInt("id"));
                System.out.println(rs.getString("name"));
                System.out.println(rs.getInt("money"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dbUtils.close();
    }
}
