package com.glc.arithmetic.test;

import com.glc.arithmetic.sort.Bubble;

import java.util.Arrays;

//冒泡排序测试
public class TestBubble {
    public static void main(String[] args) {
        Integer[] arr = {5, 4, 3, 2, 1};
        Bubble.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
