package com.dom.ination.coffeeroom.algorithms;

/**
 * Created by huoxiaobo on 2017/3/13.
 */

public class MergeSort {

    public static void mergeArray(int[] source, int start, int middle, int last, int[] tmp) {
        int m = start, n = middle + 1, k = 0;
        while (m <= middle && n <= last) {
            if (source[m] < source[n]) {
                tmp[k++] = source[m++];
            } else {
                tmp[k++] = source[n++];
            }
        }
        while (m <= middle) {
            tmp[k++] = source[m++];
        }
        while (n <= last) {
            tmp[k++] = source[n++];
        }
        for (int i = 0; i < k; i++) {
            source[start + i] = tmp[i];
        }
    }

    public static void mergeSort(int[] source, int start, int last, int[] tmp) {
        if (start < last) {
            int middle = (start + last) / 2;
            mergeSort(source, start, middle, tmp);
            mergeSort(source, middle + 1, last, tmp);
            mergeArray(source, start, middle, last, tmp);
        }
    }

    public static void main(String[] args) {
        int[] source = new int[]{8, 5, 3, 1, 4, 6, 8, 9, 4, 2, 4, 6, 8};
        mergeSort(source, 0, source.length - 1, new int[source.length]);
        for (int i = 0; i < source.length; i++) {
            System.out.print(" " + source[i]);
        }
    }
}
