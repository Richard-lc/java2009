package com.glc.javapractice;

import java.util.Scanner;

/**
 * 题目：输入某年某月某日，判断这一天是这一年的第几天？
 * 程序分析：以3月5日为例，应该先把前两个月的加起来，然后再加上5天即本年的第几天，特殊情况，闰年且输入月份大于3时需考虑多加一天。
 */
public class _14_TestDay {

    public static void main(String[] args) {

        //输入年月日
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入年：");
        int year = sc.nextInt();
        System.out.println("请输入月：");
        int month = sc.nextInt();
        System.out.println("请输入日：");
        int day = sc.nextInt();
        //计算并输入总天数
        System.out.println("这是这一年的第" + getDay(year, month, day) + "天");
    }

    public static int getDay(int year, int month, int day) {

        int theDay = 0;

        //计算是否为闰年
        if (year % 400 != 0 && year % 4 == 0) {
            theDay++;
        }
        //计算月
        for (int i = 1; i <= month-1; i++) {
            switch (i) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    theDay += 31;
                    break;
                case 2:
                    theDay += 28;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    theDay += 30;
                    break;
            }
        }
        //计算日
        theDay += day;

        return theDay;
    }
}
