package com.dom.ination.coffeeroom.other;

/**
 * Created by huoxiaobo on 2017/3/19.
 */

public class XorFindDup {

    public static int xorFindDup(int[] source) {
        int ret = source[0];
        int tmp = 1, i = 1;
        for (i = 1; i < source.length - 1; i++) {
            ret ^= source[i];
            tmp ^= source[i];
        }
        ret ^= source[i];
        return ret ^ tmp;
    }

    public static int notFindDup(int[] source) {
        int ret = Integer.MAX_VALUE;

        for (int i = 0; i < source.length; i++) {
            if (source[i] > 0) {
                source[source[i]] = -source[-source[i]];
            } else {
                source[-source[i]] = -source[-source[i]];
            }
        }

        for (int i = 0; i < source.length; i++) {
            if (source[i] > 0) {
                ret = source[i];
            } else {
                source[i] = -source[i];
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] source = new int[]{1, 2, 3, 3, 6, 5, 4, 6, 7, 8, 8};
        System.out.print(xorFindDup(source));
    }
}
