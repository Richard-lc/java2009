package com.glc.arithmetic.sort;

//快速排序
public class Quick {
    public static void sort(Integer[] arr) {
        int l = 0;
        int r = arr.length - 1;
        quickSort(arr, l, r);

    }

    public static void quickSort(Integer[] arr, int l, int r) {
        if (l < r) {
            int index = getIndex(arr, l, r);
            quickSort(arr, l, index - 1);
            quickSort(arr, index + 1, r);
        }

    }

    private static int getIndex(Integer[] arr, int l, int r) {
        int temp = arr[l];
        while (l < r) {
            while (l < r) {
                if (temp > arr[r]) {
                    break;
                }
                r--;
            }
            arr[l] = arr[r];
            while (l < r) {
                if (temp < arr[l]) {
                    break;
                }
                l++;
            }
            arr[r] = arr[l];
        }
        arr[l] = temp;
        return l;
    }
}
