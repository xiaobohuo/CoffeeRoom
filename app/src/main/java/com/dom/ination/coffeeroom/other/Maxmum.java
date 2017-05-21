package com.dom.ination.coffeeroom.other;

/**
 * Created by huoxiaobo on 2017/3/19.
 */

public class Maxmum {

    public static int max(int a, int b) {
        return a > b ? a : b;
    }

    public static int findMaxmum(int[] source, int start) {
        int length = source.length - start;
        if (length == 1) {
            return source[start];
        } else {
            return max(source[start], findMaxmum(source, start + 1));
        }

    }

    public static void main(String[] args) {
        int[] source = new int[]{1, 2, 3, 3, 6, 5, 4, 9, 7, 8, 8};
        System.out.print(findMaxmum(source, 0));
    }
}
