package com.ryl.learn.puzzlers;

import java.util.Random;


public class T94 {
    private static Random rnd = new Random();

    public static void shuffle(Object[] a) {
        for (int i = 0; i < a.length; i++) {
            swap(a, i, rnd.nextInt(a.length));
        }
//	Collections.shuffle(list);
    }

    private static void swap(Object[] a, int i, int j) {
        Object tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
