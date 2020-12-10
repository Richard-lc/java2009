package com.glc.javapractice;

import java.util.Scanner;

/* 题目：输入一行字符，分别统计出其中英文字母、空格、数字和其它字符的个数。 
 * 程序分析：利用while语句,条件为输入的字符不为'\n'.
 */

public class _07_StChar {
	public static void main(String[] args) {
		int wordCount = 0;
		int numCount = 0;
		int otherCount = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入一行字符：");
		String str = scan.nextLine();
		scan.close();
		for (int i = 0; i < str.length(); i++) {
			//判断是否为英文字符
			if ((str.charAt(i) >= 'a' && str.charAt(i) <= 'z') || (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')) {
				wordCount++;
				//判断是否为数字
			} else if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				numCount++;
				//其他字符
			} else {
				otherCount++;
			}
		}
		System.out.println("英文字母个数为：" + wordCount);
		System.out.println("数字个数为：" + numCount);
		System.out.println("其他字符个数为：" + otherCount);
	}
}
