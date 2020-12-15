package com.glc.week07.day01.login.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Richard
 * 2020/12/14 13:10
 */

@Data
@AllArgsConstructor //满参构造
@NoArgsConstructor  //无参构造
public class User {
    private Integer id;
    private String userName;
    private String password;
    private Integer age;
    private Integer sex;
}
