package com.glc.arithmetic.test;

import com.glc.arithmetic.linear.LinkList;

//单链表测试
public class TestLinkList {
    public static void main(String[] args) {

        //创建单链表对象
        LinkList<String> sl = new LinkList<>();

        //测试插入
        sl.insert("JavaSE");
        sl.insert("JavaEE");
        sl.insert("JavaME");

        sl.insert(1, "HelloWorld");

        //测试遍历
        for (String s : sl) {
            System.out.println(s);
        }
        //测试反转
        sl.reverse();
        System.out.println("-------------------------");
        for (String s : sl) {
            System.out.println(s);
        }

        System.out.println("单链表的长度为：" + sl.length());
        //测试获取
        String s = sl.get(1);
        System.out.println("获取索引1处的值为：" + s);

        //测试删除
        String remove = sl.remove(0);
        System.out.println("删除的元素为：" + remove);
        //测试清空
        sl.clear();
        System.out.println("单链表的长度为：" + sl.length());
    }
}
