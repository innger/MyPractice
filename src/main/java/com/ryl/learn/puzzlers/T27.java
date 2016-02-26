package com.ryl.learn.puzzlers;

public class T27 {
    public static void main(String[] args) {
        int i = 0;
//		while( -1 << i != 0){
//			i++;
//			System.out.println(i);
//		}
//		System.out.println(i);
        for (int val = -1; val != 0; val <<= 1) {
            i++;
        }
        System.out.println(i);
        System.out.println(System.currentTimeMillis());
        String a = "a1b2c3";
        String[] tokens = a.split("\\d");
        for (String s : tokens) {
            System.out.print(s + " ");
        }
        System.out.println();
        Boolean ab = new Boolean(true);
        Boolean bb = new Boolean(true);
        System.out.println(ab == true);
        System.out.println(bb == true);
        System.out.println(ab == bb);
        if (ab) {
            System.out.println("this is true");
        }
    }
}
