package com.glc.arithmetic.test;

import com.glc.arithmetic.linear.Stack;

//测试栈
public class TestStack {
    public static void main(String[] args) {
        //创建栈对象
        Stack<String> s = new Stack<>();

        //测试压栈
        s.push("a");
        s.push("b");
        s.push("c");
        s.push("d");

        //测试遍历
        for (String s1 : s) {
            System.out.println(s1);
        }

        //测试弹栈
        String pop = s.pop();
        System.out.println("弹出的元素为：" + pop);

        System.out.println("剩余元素个数为：" + s.size());
    }
}
