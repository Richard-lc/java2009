package com.glc.javapractice;

import java.util.Scanner;

/* 题目：输入两个正整数m和n，求其最大公约数和最小公倍数。 
 * 程序分析：利用辗转相除法。
 * 辗转相除法， 又名欧几里德算法（Euclidean algorithm），是求最大公约数的一种方法。
 * 它的具体做法是：用较大数除以较小数，再用出现的余数（第一余数）去除除数，
 * 再用出现的余数（第二余数）去除第一余数，如此反复，直到最后余数是0为止。
 * 如果是求两个数的最大公约数，那么最后的除数就是这两个数的最大公约数。
 */

public class _06_GcdTest {
	public static void main(String[] args) {
		int yushu = -1;
		Scanner scan = new Scanner(System.in);
		System.out.print("请输入正整数m：");
		int m = scan.nextInt();
		System.out.print("请输入正整数n：");
		int n = scan.nextInt();
		scan.close();
		int ji = m * n;
		if (m > n) {
			for (;;) {
				//用较大数除以较小数,求得余数
				yushu = m % n;
				//再用出现的余数去除较小的数，通过换位实现
				m = n;
				n = yushu;
				//如此重复，直到余数为0，最后的除数即为最大公约数
				if (yushu == 0) {
					break;
				}
			}
			System.out.println("最大公因数为：" + m);
			System.out.println("最小公倍数为：" + (ji / m));
		} else {
			for (;;) {
				yushu = n % m;
				n = m;
				m = yushu;
				if (yushu == 0) {
					break;
				}
			}
			System.out.println("最大公因数为：" + n);
			System.out.println("最小公倍数为：" + (ji / n));
		}
	}
}
