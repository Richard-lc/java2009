package com.glc.arithmetic.test;

import com.glc.arithmetic.sort.Shell;

import java.util.Arrays;

//希尔排序测试
public class TestShell {
    public static void main(String[] args) {
        Integer[] arr = {5, 4, 3, 2, 1};
        Shell.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
