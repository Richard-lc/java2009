package com.glc.javapractice;

/*
 * 题目：判断101-200之间有多少个素数，并输出所有素数。 
 * 程序分析：判断素数的方法：用一个数分别去除2到sqrt(这个数)，如果能被整除， 则表明此数不是素数，反之是素数。
 */

public class _02_FindPrimeNumber {
	public static void main(String[] args) {
		int num;
		int i;
		int count = 0;
		for (num = 101; num <= 200; num++) {
			//用Math.sqrt()方法对num进行开方计算
			int x = (int) Math.sqrt((double) num);
			//分别去除2到sqrt(这个数),如果能被整除，表明此数不是素数，跳出循环
			for (i = 2; i <= x; i++) {
				if (num % i == 0) {
					break;
				}
			}
			//如果都不能被整除，即循环到(i > x)，表明此数是素数，计数并输出这个数
			if (i > x) {
				count++;
				System.out.print(num + " ");
			}
		}
		System.out.println();
		System.out.println("共有" + count + "个素数");
	}
}
