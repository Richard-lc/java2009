package com.glc.arithmetic.test;

import com.glc.arithmetic.sort.Selection;

import java.util.Arrays;

//选择排序测试
public class TestSelection {
    public static void main(String[] args) {
        Integer[] arr = {5, 4, 3, 2, 1};
        Selection.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
