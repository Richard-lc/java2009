package com.glc.week06.day04.orm;

import com.glc.utils.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Richard
 * 2020/12/10 17:09
 */
public class Test {
    public static void main(String[] args) {
        DBUtils db = new DBUtils();
        String str = "select * from user";
        ResultSet rs = db.getResultSet(str);
        List<User> list = new ArrayList<>();
        try {
            while (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("userId"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setAddress(rs.getString("address"));
                user.setPhone(rs.getString("phone"));
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();

        for (User user : list) {
            System.out.println(user);
        }
    }
}
