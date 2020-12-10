package com.glc.week01.day03;

public class Demo1 {
    public static void main(String[] args) {
        String a = "A";
        String b = "A";
        String c = new String("A");
        System.out.println(a==b);
        System.out.println(a==c);
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
    }
}
