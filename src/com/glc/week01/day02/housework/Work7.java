package com.glc.week01.day02.housework;

/**
 * 编写计算器
 */

import java.util.Scanner;

public class Work7 {

    /**
     * 主函数
     * @param args
     */
    public static void main(String[] args) {

        //循环结束标志
        boolean exit = true;
        Scanner scanner = new Scanner(System.in);
        while (exit){
            System.out.println("请选择你要 1.加 2.减 3.乘 4.除 0.退出");
            //声明加减乘除标志
            int flag = scanner.nextInt();
            switch (flag) {
                //加
                case 1:
                    System.out.println("请输入加数1...");
                    double add1 = scanner.nextDouble();
                    System.out.println("请输入加数2...");
                    double add2 = scanner.nextDouble();
                    System.out.println("结果为：" + add(add1, add2));
                    break;
                //减
                case 2:
                    System.out.println("请输入被减数...");
                    double decrease1 = scanner.nextDouble();
                    System.out.println("请输入减数...");
                    double decrease2 = scanner.nextDouble();
                    System.out.println("结果为：" + decrease(decrease1, decrease2));
                    break;
                //乘
                case 3:
                    System.out.println("请输入乘数1...");
                    double multiply1 = scanner.nextDouble();
                    System.out.println("请输入乘数2...");
                    double multiply2 = scanner.nextDouble();
                    System.out.println("结果为：" + multiply(multiply1, multiply2));
                    break;
                //除
                case 4:
                    System.out.println("请输入被除数...");
                    double divide1 = scanner.nextDouble();
                    double divide2;
                    //判断除数是否为0
                    for (; ; ) {
                        System.out.println("请输入除数...");
                        divide2 = scanner.nextDouble();
                        if (divide2 == 0) {
                            System.out.println("除数不能为0，请重新输入...");
                        } else {
                            break;
                        }
                    }
                    System.out.println("结果为：" + divide(divide1, divide2));
                    break;
                //退出
                case 0:
                    exit = false;
                    break;
                //判断是否输入错误
                default:
                    System.out.println("输入错误...");
            }
        }
    }

    //加
    public static double add(double a,double b){
        return a+b;
    }

    //减
    public static double decrease(double a,double b){
        return a-b;
    }

    //乘
    public static double multiply(double a,double b){
        return a*b;
    }

    //除
    public static double divide(double a,double b){
        return a/b;
    }
}
