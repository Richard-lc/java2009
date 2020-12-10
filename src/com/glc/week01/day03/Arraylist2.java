package com.glc.week01.day03;

import java.util.ArrayList;

public class Arraylist2 {
    public static void main(String[] args) {
        int[] a = {1,1,1,2,2,2,3,3,3};
        NumberTime(a);

    }

    public static void NumberTime(int[] brr) {
        ArrayList<Integer> a = new ArrayList<>();//存数组中的数字
        ArrayList<Integer> b = new ArrayList<>();//存数组出现的次数
        a.add(brr[0]);//存数组中第一个数
        b.add(1);//记录第一个数出现了次
        for (int i = 1; i < brr.length; i++) {
            for (int j = 0; j < a.size(); j++) {
                if (brr[i] == a.get(j)) {
                    b.set(j, b.get(j) + 1);
                } else if (j == a.size() - 1) {
                    a.add(brr[i]);
                    b.add(0);
                }
            }
        }
        for (int i = 0; i < a.size(); i++) {
            System.out.println("数字" + a.get(i) + "出现了" + b.get(i) + "次");
        }
    }
}
