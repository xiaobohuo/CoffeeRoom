package com.dom.ination.coffeeroom.strings;

/**
 * Created by huoxiaobo on 2017/3/21.
 */

public class ReverseStrings {


    public static char[] reverseStrings(char[] array) {
        int begin = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == ' ') {
                swapCharArray(array, begin, i - 1);
                begin = i + 1;
            }
        }
        swapCharArray(array, begin, array.length - 1);
        return array;
    }

    public static char[] swapCharArray(char[] array, int start, int end) {
        while (start < end) {
            char tmp = array[start];
            array[start] = array[end];
            array[end] = tmp;
            start++;
            end--;
        }
        return array;
    }

    public static void main(String[] args) {
        String s = "what the fuck";
        char[] array = s.toCharArray();
        swapCharArray(array, 0, array.length - 1);
        System.out.println(new String(reverseStrings(array)));
    }
}
