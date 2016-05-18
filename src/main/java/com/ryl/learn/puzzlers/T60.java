package com.ryl.learn.puzzlers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

public class T60 {
    public static void main(String[] args) {

        List<String> original = new ArrayList<String>();
        original.add("ren");
        original.add("ren");
        original.add("yu");
        original.add("long");
        original.add("long");
        System.out.println(original);
        System.out.println(withoutDuplicate(original));
        System.out.println(Arrays.asList(parse("Shall, we, have lunch, together, today, ?")));
        System.out.println(hasMoreBitsSet(200, 300));
    }

    static <E> List<E> withoutDuplicate(List<E> original) {
        return new ArrayList<E>(new LinkedHashSet<E>(original));
    }

    static String[] parse(String string) {
        return string.split(",\\S*");
    }

    static boolean hasMoreBitsSet(int i, int j) {
        return (Integer.bitCount(i) > Integer.bitCount(j));
    }
}
