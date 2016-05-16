package com.ryl.learn.puzzlers;

import java.util.ArrayList;
import java.util.List;

/**
 * OutOfMemoryTest
 * 不断累加list
 */
public class OutofMemoryTest {

    private static final int SIZE = 1024 * 1024;


    public static void main(String[] args) {
        List<Integer[]> aList = new ArrayList<Integer[]>();
        for (; ; ) {
            Integer[] a = new Integer[SIZE];
            aList.add(a);
        }
    }
}
