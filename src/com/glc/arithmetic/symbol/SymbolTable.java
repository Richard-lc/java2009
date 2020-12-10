package com.glc.arithmetic.symbol;

/**
 * 符号表：链表实现
 *
 * @author Richard
 * 2020/12/9 19:18
 */
public class SymbolTable<Key, Value> {
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

    public SymbolTable() {
        this.head = new Node(null, null, null);
        this.N = 0;
    }

    //获取符号表中键值对的个数
    public int size() {
        return N;
    }

    //往符号表中插入键值对
    public void put(Key key, Value value) {
        //符号表中已经存在了键为key的键值对，那么只需要找到该结点，替换值为value即可
        Node n = head;
        while (n.next != null) {
            n = n.next;
            if (n.key.equals(key)) {
                n.value = value;
                return;
            }
        }
        //如果符号表中不存在键为key的键值对，只需要创建新结点，保存要插入的键值对，把新结点插入到链表的头部即可
        Node newNode = new Node(key, value, null);
        newNode.next = head.next;
        head.next = newNode;
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
