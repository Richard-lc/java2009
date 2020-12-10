package com.glc.arithmetic.test;

import com.glc.arithmetic.sort.Merge;

import java.util.Arrays;

//归并排序测试
public class TestMerge {
    public static void main(String[] args) {
        Integer[] arr = {2, 3, 6, 1, 5, 4};
        Merge.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
