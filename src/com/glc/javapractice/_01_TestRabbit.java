package com.glc.javapractice;

/*
 * 题目：古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，
 * 小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，
 * 问每个月的兔子总数为多少？ 
 * 程序分析：兔子的规律为数列1,1,2,3,5,8,13,21....
 */

//即斐波那契数列：后者等于前两者之和
public class _01_TestRabbit {

	public static void main(String[] args) {
		//输出每个月的兔子总数量
		for (int month = 1; month <= 12; month++) {
			System.out.println("第" + month + "个月兔子数量为：" + num(month));
		}
	}

	public static int num(int month) {
		//前两月数量都为1
		if (month == 1 || month == 2) {
			return 1;
		} else {
			//当前月份的数量等于前两月数量之和 用递归的思想求出总数量
			return num(month - 2) + num(month - 1);
		}
	}
}
