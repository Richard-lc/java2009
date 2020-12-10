package com.glc.arithmetic.linear.fast_slow_point;

//使用快慢指针解决约瑟夫问题
public class Joseph {
    public static void main(String[] args) {
        //1.构建循环链表，包含41个结点，分别存储1-41之间的值
        //用来记录首结点
        Node<Integer> first = null;
        //用来记录前一个结点
        Node<Integer> pre = null;

        for (int i = 1; i <= 41; i++) {
            //如果是第一个结点
            if (i == 1) {
                first = new Node<>(i, null);
                pre = first;
                continue;
            }
            //如果不是第一个结点
            Node<Integer> newNode = new Node<>(i, null);
            pre.next = newNode;
            pre = newNode;
            //如果是最后一个结点，指向第一个结点
            if (i == 41) {
                pre.next = first;
            }
        }

        //2.定义计数器count，模拟报数
        int count = 0;
        //3.遍历循环链表
        //记录每次遍历拿到的结点，默认从首结点开始
        Node<Integer> n = first;
        //记录当前结点的上一个结点
        Node<Integer> before = null;
        while (n != n.next) {
            //模拟报数
            count++;
            //判断当前报数是否为3
            if (count == 3) {
                //如果是3，则把当前结点删除，打印当前结点，重置count=0，让当前结点n后移
                before.next = n.next;
                System.out.print(n.item + ",");
                count = 0;
                n = n.next;
            } else {
                //如果不是3，before变为当前结点，当前结点后移
                before = n;
                n = n.next;
            }
        }

        //打印最后一个元素
        System.out.println(n.item);

    }


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
}
