package com.glc.arithmetic.linear.fast_slow_point;

//快慢指针找中间值问题
public class MidValue {

    //结点类
    private static class Node<T> {
        //存储数据
        T item;
        //下一个结点
        Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        //创建结点
        Node<String> first = new Node<String>("aa", null);
        Node<String> second = new Node<String>("bb", null);
        Node<String> third = new Node<String>("cc", null);
        Node<String> forth = new Node<String>("dd", null);
        Node<String> fifth = new Node<String>("ee", null);
        Node<String> sixth = new Node<String>("ff", null);
        Node<String> seventh = new Node<String>("gg", null);

        //完成结点的指向
        first.next = second;
        second.next = third;
        third.next = forth;
        forth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;

        //查找中间值
        String mid = getMid(first);
        System.out.println("中间结点的值为：" + mid);
    }

    /**
     * 使用快慢指针解决中间值问题
     *
     * @param first 链表的首结点
     * @return 链表的中间结点的值
     */
    private static String getMid(Node<String> first) {
        //定义快慢指针
        Node<String> fast = first;
        Node<String> slow = first;
        //使用两个指针遍历链表，当快指针指向的结点没有下一个结点了，慢指针指向的结点就是中间结点
        while (fast != null && fast.next != null) {
            //快指针走两步，慢指针走一步
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.item;
    }
}
