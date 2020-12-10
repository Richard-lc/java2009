package com.glc.arithmetic.linear;

import java.util.Iterator;

//栈：链表实现
public class Stack<T> implements Iterable<T> {
    //记录首结点
    private Node head;
    //栈中元素的个数
    private int N;

    @Override
    public Iterator<T> iterator() {
        return new Sitrator();
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

    public Stack() {
        this.head = new Node(null, null);
        this.N = 0;
    }

    //判断当前栈中元素是否为0
    public boolean isEmpty() {
        return N == 0;
    }

    //获取当前栈中元素个数
    public int size() {
        return N;
    }

    //把t元素压入栈中
    public void push(T t) {
        //找到首结点指向的第一个结点
        Node oldFirst = head.next;
        //创建新结点
        Node newNode = new Node(t, null);
        //让首结点指向新结点
        head.next = newNode;
        //让新结点指向原来的第一个结点
        newNode.next = oldFirst;
        //元素个数+1
        N++;
    }

    //弹出栈顶元素
    public T pop() {
        //找到首结点指向的第一个结点
        Node oldFirst = head.next;
        if (oldFirst == null) {
            return null;
        }
        //让首结点指向原来第一个结点的下一个结点
        head.next = oldFirst.next;
        //元素个数-1
        N--;
        return oldFirst.item;
    }

    private class Sitrator implements Iterator<T> {
        private Node n;

        public Sitrator() {
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
