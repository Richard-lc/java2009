package com.glc.arithmetic.test;

import com.glc.arithmetic.linear.SequenceList;

//顺序表测试
public class TestSequenceList {
    public static void main(String[] args) {

        //创建顺序表对象
        SequenceList<String> sl = new SequenceList<>(3);

        //测试插入
        sl.insert("JavaSE");
        sl.insert("JavaEE");
        sl.insert("JavaME");

        sl.insert(1, "HelloWorld");

        System.out.println("顺序表的长度为：" + sl.length());
        //测试遍历
        for (String s : sl) {
            System.out.println(s);
        }
        //测试获取
        String s = sl.get(1);
        System.out.println("获取索引1处的值为：" + s);

        //测试删除
        String remove = sl.remove(0);
        System.out.println("删除的元素为：" + remove);
        //测试清空
        sl.clear();
        System.out.println("顺序表的长度为：" + sl.length());

        //测试清空后获取
        String s1 = sl.get(1);
        System.out.println("获取索引1处的值为：" + s1);
    }
}
