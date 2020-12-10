package com.glc.week01.day02.demo;

import java.util.Scanner;

public class Demo1 {

    public static void main(String[] args) {
        Work_1();
        //Work_2();
        //Work_3();
        //Work_4();

    }

    public static void Work_1() {

        //ATM自动银行服务系统
        int num = -1;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("=====================欢迎使用ATM自动银行服务======================");
            System.out.println("1：开户 2：存款 3：取款 4：转账 5：查询余额 6：修改密码 0：退出");
            System.out.println("================================================================");
            System.out.println("请输入操作编号：");
            num = scanner.nextInt();
            switch (num) {
                case 1:
                    System.out.println("--执行开户功能--");
                    break;
                case 2:
                    System.out.println("--执行存款功能--");
                    break;
                case 3:
                    System.out.println("--执行取款功能--");
                    break;
                case 4:
                    System.out.println("--执行转账功能--");
                    break;
                case 5:
                    System.out.println("--执行查询余额功能--");
                    break;
                case 6:
                    System.out.println("--执行修改密码功能--");
                    break;
                case 0:
                    System.out.println("--执行退出功能--");
                    break;
                default:
                    System.out.println("--输入错误，请重新输入--");
            }
        } while (num != 0);

    }

    public static void Work_2() {

        //打印直角三角形
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

    public static void Work_3() {

        //打印等腰三角形
        for (int i = 1; i <= 10; i++) {//控制行数
            for (int k = 1; k <= 10 - i; k++) {//控制空格的个数
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {//控制打印的图形
                System.out.print("*");
            }
            System.out.println();//控制换行
        }

    }

    public static void Work_4() {

        //计算N的阶乘
        int i;
        int result = 1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个正整数：");
        int num = scanner.nextInt();
        if (num < 1) {
            System.out.println();
        }
        for (i = 1; i < num + 1; i++) {
            result *= i;
        }
        System.out.println("结果为：" + result);
    }
}
