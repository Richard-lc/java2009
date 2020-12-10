package com.glc.arithmetic.sort;

//冒泡排序
public class Bubble {

    public static void sort(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            Boolean flag = true;
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }
}
