package com.glc.javapractice;

/**
 * 题目：一个数如果恰好等于它的因子之和，这个数就称为"完数"。例如6=1＋2＋3.编程 找出1000以内的所有完数。
 */
public class _09_WanShu {

    public static void main(String[] args) {

        int num;
        for (int i = 1; i < 1000; i++) {
            num = 0;
            for (int j = 1; j < i; j++) {
                //从1到本身，能整除的即为因子
                if (i % j == 0) {
                        num += j;
                }
            }
            //这个数如果恰好等于它的因子之和，即为"完数"
            if (num == i) {
                System.out.println(i);
            }
        }
    }
}
