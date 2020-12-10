package com.glc.javapractice;

/* 题目：求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个数字。
 * 例如2+22+222+2222+22222(此时共有5个数相加)，几个数相加有键盘控制。 
 * 程序分析：关键是计算出每一项的值。
 */

import java.util.Scanner;

public class _08_TestAdd {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入a的值...");
        int a = sc.nextInt();
        System.out.println("请输入n的值...");
        int n = sc.nextInt();
        System.out.println(getsum(a, n));
    }

    public static int getsum(int a, int n) {

        int temp = 0;
        for (int i = 1; i <= n; i++) {
            //Math.pow(10, i) 十的i次方
            //Math.pow(10, i) - 1 即为9+99+999+9999...  （temp / 9 * a）即为题目所求
            temp += Math.pow(10, i) - 1;
            if (i < n) {
                System.out.print((int) (Math.pow(10, i) - 1 )/ 9 * a + "+");
            } else {
                System.out.print((int) (Math.pow(10, i) - 1) / 9 * a + "=");
            }
        }
        return temp / 9 * a;
    }
}
