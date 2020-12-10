package com.glc.javapractice;

import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * 题目：输入三个整数x,y,z，请把这三个数由小到大输出。
 * 程序分析：我们想办法把最小的数放到x上，先将x与y进行比较，
 * 如果x>y则将x与y的值进行交换，然后再用x与z进行比较，
 * 如果x>z则将x与z的值进行交换，这样能使x最小。
 */

//由于java中“对基本类型的变量是不支持引用传递的”，所以根本不能像c/c++那样直接传地址
//解决方法：用数组进行传递
public class _15_TestCompare {

    public static void main(String[] args) {

        //声明一个数组来存放x,y,z
        int[] a = new int[3];
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入x：");
        a[0] = sc.nextInt();
        System.out.println("请输入y：");
        a[1] = sc.nextInt();
        System.out.println("请输入z：");
        a[2] = sc.nextInt();
        //进行排序并输出
        px(a);
        System.out.println("由小到大输出为：" + a[0] + "，" + a[1] + "，" + a[2]);
    }


    //排序方法，两两交换
    public static void px(int[] a) {
        if (a[0] > a[1]) {
            exchange(a, 0, 1);
        }
        if (a[0] > a[2]) {
            exchange(a, 0, 2);
        }
        if (a[1] > a[2]) {
            exchange(a, 1, 2);
        }
    }

    //交换方法，传入数组及下标
    public static void exchange(int[] a, int x, int y) {
        int temp;
        temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

}
