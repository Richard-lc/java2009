package com.glc.javapractice;

/**
 * 题目：一个整数，它加上100后是一个完全平方数，再加上168又是一个完全平方数，请问该数是多少？
 * 程序分析：在10万以内判断，先将该数加上100后再开方，再将该数加上268后再开方，如果开方后的结果满足如下条件，即是结果。
 */
public class _13_FindNumber {

    public static void main(String[] args) {

        //在10万以内判断，先将该数加上100后再开方，再将该数加上268后再开方，如果开方后的结果满足如下条件，即是结果
        for (int i = 0;i<99999;i++){
            if ((i+100)==((int)Math.sqrt(i+100)*(int)Math.sqrt(i+100))){
                if ((i+268)==((int)Math.sqrt(i+268)*(int)Math.sqrt(i+268))){
                    System.out.println("该数为："+i);
                }
            }
        }
    }
}
