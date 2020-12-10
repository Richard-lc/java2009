package com.glc.arithmetic.linear;

import java.util.Iterator;

/**
 * 队列：链表实现
 *
 * @author Richard
 * 2020/12/9 18:49
 */
public class Queue<T> implements Iterable<T> {
    //记录首结点
    private Node head;
    //记录最后一个结点
    private Node last;
    //记录队列中元素的个数
    private int N;

    @Override
    public Iterator<T> iterator() {
        return new Qitrator();
    }

    //结点类
    private class Node {

        //存储数据
        T item;
        //下一个结点
        Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public Queue() {
        this.head = new Node(null, null);
        this.last = null;
        this.N = 0;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return N == 0;
    }

    //返回队列中元素的个数
    public int size() {
        return N;
    }

    //向队列中插入元素t
    public void enqueue(T t) {
        //当前尾结点为null
        Node newNode = new Node(t, null);
        if (last == null) {
            head.next = newNode;
            last = newNode;
        } else {
            //当前尾结点不为null
            last.next = newNode;
            last = newNode;
        }
        //元素个数+1
        N++;
    }

    //从队列中拿出一个元素
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }

        Node oldFirst = head.next;
        head.next = oldFirst.next;
        N--;

        if (isEmpty()) {
            last = null;
        }
        return oldFirst.item;
    }

    private class Qitrator implements Iterator<T> {
        private Node n;

        public Qitrator() {
            this.n = head;
        }

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public T next() {
            n = n.next;
            return n.item;
        }
    }
}
