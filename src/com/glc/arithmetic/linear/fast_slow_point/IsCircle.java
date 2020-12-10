package com.glc.arithmetic.linear.fast_slow_point;

//使用快慢指针判断链表是否有环问题
public class IsCircle {
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

        //成环
        seventh.next = third;

        //查找是否有环
        boolean isCircle = isCircle(first);
        System.out.println("first链表是否有环：" + isCircle);

        //查找环的入口
        Node entrance = getEntrance(first);
        System.out.println("first链表环的入口为：" + entrance.item);
    }

    /**
     * 查找环的入口
     *
     * @param first 链表首结点
     * @return 环入口结点
     */
    private static Node getEntrance(Node<String> first) {
        //定义快慢指针和临时指针
        Node fast = first;
        Node slow = first;
        Node temp = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            //快慢指针相遇时，将临时指针指向首结点，步长与慢指针一致，当临时指针与慢指针相遇时即为环的入口
            if (fast.equals(slow)) {
                temp = first;
                continue;
            }

            if (temp != null) {
                temp = temp.next;
                if (slow.equals(temp)) {
                    return temp;
                }
            }
        }
        return temp;
    }

    /**
     * 判断链表是否有环
     *
     * @param first 链表首结点
     * @return true为有环，false为无环
     */
    private static boolean isCircle(Node<String> first) {
        //定义快慢指针
        Node fast = first;
        Node slow = first;
        //如果快慢指针相遇，则有环
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast.equals(slow)) {
                return true;
            }
        }
        return false;
    }
}
