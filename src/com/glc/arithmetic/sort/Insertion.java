package com.glc.arithmetic.sort;

//插入排序
public class Insertion {
    public static void sort(Integer arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            int temp = arr[j];
            while (j > 0 && temp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }
}
