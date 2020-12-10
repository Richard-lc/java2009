package com.glc.design_pattern.seven_design_philosophy._7_composite_reuse_principle.a;

import java.util.HashSet;
import java.util.Set;

/**
 * 需求：制作一个组合，该集合能够记录下曾经添加过多少元素。（不只是统计某一时刻）
 */

class MySet extends HashSet {
    private int count = 0;

    public int getCount() {
        return count;
    }

    @Override
    public boolean add(Object o) {
        count++;
        return super.add(o);
    }
}

public class negtive_1 {
    public static void main(String[] args) {
        MySet mySet = new MySet();
        mySet.add("111111");
        mySet.add("22222222222222");
        mySet.add("2333");


        Set hashSet = new HashSet();
        hashSet.add("集合+11111");
        hashSet.add("集合+22222222");
        hashSet.add("集合+233333");
        mySet.addAll(hashSet);

        System.out.println(mySet.getCount());
    }
}

/*
    看似解决了需求，add 方法可以成功将count进行自加，
    addAll方法通过方法内调用add，可以成功将count进行增加操作。

    缺陷：JDK版本如果未来进行更新，addAll方法不再通过方法内调用add，
    那么当调用addAll进行集合添加元素时，count将不无从进行自加。需求也将无法满足。

    HashMap 就在 1.6 1.7 1.8就分别更新了三次。
*/