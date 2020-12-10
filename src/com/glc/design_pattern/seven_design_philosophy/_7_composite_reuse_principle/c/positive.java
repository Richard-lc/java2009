package com.glc.design_pattern.seven_design_philosophy._7_composite_reuse_principle.c;


import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

//使用组合而不用继承
//解决了以上的问题
class MySet {
    private HashSet hashSet = new HashSet();

    private int count = 0;

    public int getCount() {
        return count;
    }

    public boolean add(Object o) {
        count++;
        return hashSet.add(o);
    }

    public boolean addAll(Collection c) {
        count += c.size();
        return hashSet.addAll(c);
    }
}

public class positive {
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
    利用组合，实现解耦，将HashSet和自定义类MySet由原来的继承关系改为了低耦合的组合关系。
 */