package com.glc.week02;

//用递归输出斐波那契数列
public class Demo2 {

    public static void main(String[] args) {
        for (int i = 1; i < 20; i++) {
            System.out.print(fbnq(i) + " ");
        }
    }

    public static int fbnq(int i) {
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        return fbnq(i - 2) + fbnq(i - 1);
    }
}
