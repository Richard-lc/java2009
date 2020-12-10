package com.glc.javapractice;

import java.util.Scanner;

/**
 * 题目：企业发放的奖金根据利润提成。
 * 利润(I)低于或等于10万元时，奖金可提10%；
 * 利润高于10万元，低于20万元时，低于10万元的部分按10%提成，高于10万元的部分，可提成7.5%；
 * 20万到40万之间时，高于20万元的部分，可提成5%；
 * 40万到60万之间时高于40万元的部分，可提成3%；
 * 60万到100万之间时，高于60万元的部分，可提成1.5%，高于100万元时，超过100万元的部分按1%提成，
 * 从键盘输入当月利润I，求应发放奖金总数？
 * 程序分析：请利用数轴来分界，定位。注意定义时需把奖金定义成长整型。
 */
public class _12_MoneyAward {

    public static void main(String[] args) {

        //输入利润值
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入利润（单位：万）：");
        double lr = sc.nextLong();
        //计算奖金
        double award = award(lr);
        System.out.println("应发放奖金为：" + award+"万元");
    }

    public static double award(double lr) {

        double award = 0;
        if (lr <= 10) {
            award = lr * 0.1;
        } else if (lr <= 20) {
            award = 10 * 0.1 + (lr - 10) * 0.075;
        } else if (lr <= 40) {
            award = 10 * 0.1 + 10 * 0.075 + (lr - 20) * 0.05;
        } else if (lr <= 60) {
            award = 10 * 0.1 + 10 * 0.075 + 20 * 0.05 + (lr - 40) * 0.03;
        } else if (lr <= 100) {
            award = 10 * 0.1 + 10 * 0.075 + 20 * 0.05 + 20 * 0.03 + (lr - 60) * 0.015;
        } else {
            award = 10 * 0.1 + 10 * 0.075 + 20 * 0.05 + 20 * 0.03 + 40 * 0.015 + (lr - 100) * 0.01;
        }
        return award;
    }
}
