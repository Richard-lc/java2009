package com.glc.week01.day02.housework;

import java.util.Scanner;

/**
 * 判断用户是否是幸运用户
 */
public class Work8 {
    public static void main(String[] args) {

        //输入会员卡号并判断是否符合规范
        int num;
        for (; ; ) {
            System.out.println("请输入客户四位会员卡号");
            Scanner scanner = new Scanner(System.in);
            num = scanner.nextInt();
            if (num>9999||num<1){
                System.out.println("卡号错误，请重新输入...");
            }else{
                break;
            }
        }
        //获取每一位的值
        int a = num / 1000 % 10;
        int b = num / 100 % 10;
        int c = num / 10 % 10;
        int d = num % 10;

        //求和
        int sum = a + b + c + d;

        //判断是否为幸运客户并输出
        boolean flag = sum % 2 != 0 ? true : false;
        if (flag) {
            System.out.println("该用户为幸运客户");
        } else {
            System.out.println("该用户为非幸运客户");
        }
    }
}
