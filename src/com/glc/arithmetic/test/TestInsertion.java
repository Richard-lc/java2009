package com.glc.arithmetic.test;

import com.glc.arithmetic.sort.Insertion;

import java.util.Arrays;

//插入排序测试
public class TestInsertion {
    public static void main(String[] args) {
        Integer[] arr = {5, 4, 3, 2, 1};
        Insertion.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
