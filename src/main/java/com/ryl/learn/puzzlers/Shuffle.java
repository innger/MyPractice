package com.ryl.learn.puzzlers;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class Shuffle {

    private static Random rnd = new Random();

    public static void shuffle(Object[] a) {
        for (int i = 0; i < a.length; i++) {
            swap(a, i, rnd.nextInt(a.length));
        }
    }

    /**
     * Collection.shuffle的实现 i-1 与 rnd.nextInt(i) 交换
     * @param arr object[]
     */
    public static void shuffle1(Object[] arr) {
        int len = arr.length;
        for (int i = len; i > 1; i--)
            swap(arr, i - 1, rnd.nextInt(i));
    }

    private static void swap(Object[] a, int i, int j) {
        Object tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        String[] strArr = new String[]{"a", "b", "c", "d", "e"};
        List<String> strList = Lists.newArrayList(strArr);

        System.out.println("before: " + Arrays.toString(strArr));
        shuffle(strArr);
        System.out.println("after: " + Arrays.toString(strArr));

        System.out.println("before: " + strList);
        Collections.shuffle(strList);
        System.out.println("after: " + strList);
    }
}
