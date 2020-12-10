package com.glc.week01.day05;

import java.util.Scanner;

/**
 * 模拟银行取款功能,用户输入数字账户19位及密码6位，3次错误提示并结束，
 * 输入正确的用户再输入取款金额，若输入取款金额不大于零，
 * 提示“输入的金额不正确”，若取款金额大于零并且小于余额，则将余额更新，提示“取款成功”，并输出余额。
 * 若取款金额大于或等于余额，提示“余额不足”。假设初始金额为5000元，银行要求账户余额不能低于1元。
 */
public class Bank {

    public static void main(String[] args) {
        //声明变量
        String account = "8888888888888888888";
        String password = "666666";
        int money = 5000;
        Scanner sc = new Scanner(System.in);
        loop:
        do {
            System.out.println("--------------欢迎来到银行取款系统---------------");
            //对输入的账号密码进行判断，错误3次，用break强制退出
            for (int i = 0; i < 3; i++) {
                System.out.println("请输入你的19位账号：");
                String theAccount = sc.next();
                System.out.println("请输入你的6位密码：");
                String thePassword = sc.next();
                if (!(thePassword.equals(password)&&theAccount.equals(account))) {
                    if (i == 2) {
                        System.out.println("账号密码不匹配已达3次，强制退出...");
                        break loop;
                    }
                    System.out.println("账号密码不匹配，请重新输入...");
                }else{
                    break;
                }
            }
            //密码正确，进入系统，输入取款金额
            System.out.println("请输入取款金额：");
            int getMoney = sc.nextInt();
            //取款金额小于等于0，提示金额不正确
            if (getMoney <= 0) {
                System.out.println("输入的金额不正确...");
                //取款金额小于现有金额，取款成功，更新余额并输出余额
            } else if (getMoney < money) {
                money -= getMoney;
                System.out.println("取款成功...");
                System.out.println("余额为：" + money);
                //取款金额大于现有余额，提示余额不足
            } else {
                System.out.println("余额不足...");
            }
        } while (false);
    }
}
