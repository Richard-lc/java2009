package com.glc.week02;

import java.util.Scanner;

//用递归计算n的阶乘
public class Demo1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入正整数n:");
        int n = sc.nextInt();
        System.out.println(n + "的阶乘为：" + jc(n));
    }

    public static int jc(int n) {
        if (n == 0) {
            return 1;
        }
        return n * jc(n - 1);
    }
}
