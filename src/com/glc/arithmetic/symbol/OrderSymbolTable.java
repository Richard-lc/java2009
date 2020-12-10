package com.glc.arithmetic.symbol;

/**
 * 有序符号表：链表实现（根据键的值排序）
 *
 * @author Richard
 * 2020/12/9 19:18
 */
public class OrderSymbolTable<Key extends Comparable<Key>, Value> {
    //记录首结点
    private Node head;
    //记录符号表中元素的个数
    private int N;

    //结点类
    private class Node {
        //键
        public Key key;
        //值
        public Value value;
        //下一个结点
        public Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public OrderSymbolTable() {
        this.head = new Node(null, null, null);
        this.N = 0;
    }

    //获取符号表中键值对的个数
    public int size() {
        return N;
    }

    //往符号表中插入键值对
    public void put(Key key, Value value) {
        //定义两个结点，分别记录当前结点和当前结点的上一个结点
        Node curr = head.next;
        Node pre = head;
        while (curr != null && key.compareTo(curr.key) > 0) {
            //变换结点
            pre = curr;
            curr = curr.next;
        }
        //如果当前结点的key和要插入的key一样，则替换
        if (curr != null && curr.key.compareTo(key) == 0) {
            curr.value = value;
        }
        //不一样则插入
        Node newNode = new Node(key, value, curr);
        pre.next = newNode;
        //元素个数+1
        N++;
    }

    //删除符号表中键为key的键值对
    public void delete(Key key) {
        //找到键为key的结点，把该结点从链表中删除
        Node n = head;
        while (n.next != null) {
            if (n.next.key.equals(key)) {
                n.next = n.next.next;
                N--;
                return;
            }
            //变换n
            n = n.next;
        }
    }

    //从符号表中获取键为key对应的值
    public Value get(Key key) {
        //找到键为key的结点
        Node n = head;
        while (n.next != null) {
            n = n.next;
            if (n.key.equals(key)) {
                return n.value;
            }
        }
        return null;
    }

}
