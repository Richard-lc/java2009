package com.glc.javapractice;

/**
 * 题目：一球从100米高度自由落下，每次落地后反跳回原高度的一半；再落下，求它在第10次落地时，共经过多少米？第10次反弹多高？
 */
public class _10_TestBall {

    public static void main(String[] args) {
        double sum = 0;
        double height = 100;
        System.out.print("每次弹起的高度分别为：");
        for (int i=0;i<10;i++){
            //落下时经过的路程
            sum += height;
            //每次弹起的高度
            height = height(height);
            System.out.print(height+" ");
            //弹起时经过的路程
            sum += height;
        }
        System.out.println();
        //计算第十次落地时共经过的路程，需减去最后一次弹起的路程
        System.out.println(sum-height);
        //最后一次弹起的高度
        System.out.println(height);
    }

    public static double height(double height) {

        return height/2;
    }
}
