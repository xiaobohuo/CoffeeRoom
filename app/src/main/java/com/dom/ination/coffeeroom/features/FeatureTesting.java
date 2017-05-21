package com.dom.ination.coffeeroom.features;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by huoxiaobo on 17/2/12.
 */

public class FeatureTesting<T> {

//    Collection
    static Set<String> set = new LinkedHashSet<>();
    T[] t;

    public static void main(String[] args){
        String str1 = new String("hello world");
        String str2 = new String("hello world");
        int str1HashCode = str1.hashCode();
        int str2HashCode = str2.hashCode();
        System.out.print("");

    }

}
