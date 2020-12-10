package com.glc.arithmetic.test;

import com.glc.arithmetic.sort.Quick;

import java.util.Arrays;

//快速排序测试
public class TestQuick {
    public static void main(String[] args) {
        Integer[] arr = {5, 4, 3, 2, 1};
        Quick.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
