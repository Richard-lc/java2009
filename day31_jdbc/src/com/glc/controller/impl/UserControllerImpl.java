package com.glc.controller.impl;

import com.glc.controller.IUserController;
import com.glc.entity.User;
import com.glc.service.IUserService;
import com.glc.service.impl.UserServiceImpl;

import java.util.List;
import java.util.Scanner;

/**
 * @author Richard
 * 2020/12/15 11:11
 */
public class UserControllerImpl implements IUserController {
    private IUserService userService;
    private Scanner scanner;

    public UserControllerImpl() {
        this.userService = new UserServiceImpl();
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void menu() {
        System.out.println("=========学生管理系统v1.0=============");
        while (true) {
            System.out.println("1.新增学生  2.修改学生  3.删除学生  4.查询学生  5.登录  6.退出");
            Integer num = checkNum();//判断输入是否合法
            switch (num) {
                case 1:
                    addUser();//新增用户
                    break;
                case 2:
                    updateUser();//修改用户
                    break;
                case 3:
                    deleteUser();//删除用户
                    break;
                case 4:
                    getUserList();//查询用户
                    break;
                case 5:
                    login();//查询用户
                    break;
                case 6:
                    System.out.println("谢谢使用，再见~");
                    return;
            }
        }
    }

    @Override
    public void login() {
        System.out.println("请输入用户名：");
        String username = scanner.next();

        if (username == null || username.length() == 0) {
            System.err.println("用户名不能为空！");
            return;
        }

        System.out.println("请输入密码：");
        String password = scanner.next();

        User user = userService.login(username, password);

        if (user != null) {
            System.out.println("欢迎你，【" + user.getUserName() + "】!");
        } else {
            System.err.println("用户名与密码不匹配！");
        }

    }

    private Integer checkNum() {
        Integer num = 0;
        while (true) {
            System.out.println("请输入你的操作：");
            try {
                num = Integer.parseInt(scanner.next());
            } catch (NumberFormatException e) {
                System.err.println("输入有误，请重新输入！");
                continue;
            }
            if (num < 1 || num > 6) {
                System.err.println("请输入数字1-6！");
                continue;
            }
            return num;
        }
    }

    @Override
    public void addUser() {
        System.out.println("请输入用户名：");
        String username = scanner.next();
        User checkUser = userService.getUserByUsername(username);
        if (checkUser != null) {
            System.out.println("【" + username + "】" + "用户已存在！");
            return;
        }

        User user = inputInfo();
        user.setUserName(username);

        int i = userService.addUser(user);

        if (i != 0) {
            System.out.println("添加成功！");
        } else {
            System.out.println("添加失败！");
        }
    }

    private User inputInfo() {
        System.out.println("请输入密码：");
        String password = scanner.next();
        System.out.println("请输入年龄：");
        Integer age = scanner.nextInt();
        System.out.println("请输入性别：");
        Integer sex = scanner.nextInt();

        User user = new User();
        user.setPassword(password);
        user.setAge(age);
        user.setSex(sex);
        return user;
    }

    @Override
    public void updateUser() {
        System.out.println("请输入要修改的用户名：");
        String username = scanner.next();
        User checkUser = userService.getUserByUsername(username);
        if (checkUser == null) {
            System.out.println("【" + username + "】" + "用户不存在！");
            return;
        }

        User user = inputInfo();
        user.setUserName(username);

        int i = userService.updateUser(user);
        if (i != 0) {
            System.out.println("修改成功！");
        } else {
            System.out.println("修改失败！");
        }
    }

    @Override
    public void deleteUser() {
        System.out.println("请输入要删除的用户名：");
        String username = scanner.next();
        User checkUser = userService.getUserByUsername(username);
        if (checkUser == null) {
            System.out.println("【" + username + "】" + "用户不存在！");
            return;
        }

        int i = userService.deleteUserByUserName(username);
        if (i != 0) {
            System.out.println("【" + username + "】" + "删除成功！");
        } else {
            System.out.println("删除失败！");
        }
    }

    @Override
    public void getUserList() {
        List<User> userList = userService.getUserList();

        for (User u : userList) {
            System.out.println(u);
        }
        return;
    }
}
