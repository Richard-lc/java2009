package com.glc.week06.day04;

import java.sql.ResultSet;

/**
 * @author Richard
 * 2020/12/10 10:24
 */
public class JDBCTest {

    public static void main(String[] args) {
        DB db = new DB();
//        Connection conn = db.getConnection();
        String str = "delete from account where id = 4;";
//        String str = "insert into account values(4,'ww',500)";
        db.execute(str);

        ResultSet rs = db.getResultSet("select * from account");
        System.out.println(rs);
        db.close();
    }
}
