package com.glc.javapractice;

/**
 * 题目：有1、2、3、4个数字，能组成多少个互不相同且无重复数字的三位数？都是多少？
 * 程序分析：可填在百位、十位、个位的数字都是1、2、3、4。组成所有的排列后再去掉不满足条件的排列。
 */
public class _11_TestTN {

    public static void main(String[] args) {

        int count=0;
        //百位
        for (int i=1;i<5;i++){
            //十位
            for (int j=1;j<5;j++){
                //个位
                for (int k=1;k<5;k++){
                    //去掉不满足条件的排列
                    if (i!=k&&i!=j&&j!=k){
                        //输出每个数
                        System.out.print(""+i+j+""+k+" ");
                        //计数
                        count++;
                    }
                }
            }
        }
        System.out.println();
        System.out.println("共有"+count+"个无重复的三位数");
    }
}
