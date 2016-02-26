package com.ryl.learn.puzzlers;

public class Swap {


    public static void main(String[] args) {
        Integer i = new Integer(2);
        Integer j = new Integer(3);
        swap(i, j);
        System.out.println(i + " : " + j);
    }

    //e300 300

    private static void swap(Integer i, Integer j) {
        int temp = i;
        i = j;
        j = temp;
        System.out.println(i + " : " + j);
    }
}
