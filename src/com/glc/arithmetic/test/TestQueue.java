package com.glc.arithmetic.test;

import com.glc.arithmetic.linear.Queue;

/**
 * 队列测试
 *
 * @author Richard
 * 2020/12/9 19:13
 */
public class TestQueue {
    public static void main(String[] args) {
        //创建队列对象
        Queue<Integer> q = new Queue<>();

        //测试入队
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);

        //测试遍历
        for (Integer i : q) {
            System.out.println(i);
        }

        //测试出队
        Integer dequeue = q.dequeue();
        System.out.println("出队元素为：" + dequeue);
        System.out.println("剩余元素个数为：" + q.size());
    }
}
