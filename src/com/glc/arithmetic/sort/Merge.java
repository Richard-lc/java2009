package com.glc.arithmetic.sort;

public class Merge {
    private static Integer[] assist;//辅助数组

    public static void sort(Integer arr[]) {
        assist = new Integer[arr.length];
        int l = 0;
        int r = arr.length - 1;
        mergeSort(arr, l, r);
    }

    public static void mergeSort(Integer[] arr, int l, int r) {
        if (l < r) {
            //将数组分为左右两组，分别进行排序
            int mid = (l + r) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);

            //归并
            merge(arr, l, mid, r);
        }

    }

    //归并
    private static void merge(Integer[] arr, int l, int mid, int r) {

        int i = l;
        int p1 = l;
        int p2 = mid + 1;

        while (p1 <= mid && p2 <= r) {
            if (arr[p1] <= arr[p2]) {
                assist[i++] = arr[p1++];
            } else {
                assist[i++] = arr[p2++];
            }
        }

        while (p1 <= mid) {
            assist[i++] = arr[p1++];
        }
        while (p2 <= r) {
            assist[i++] = arr[p2++];
        }
        for (int index = l; index <= r; index++) {
            arr[index] = assist[index];
        }
    }
}
