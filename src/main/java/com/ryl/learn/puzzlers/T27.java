package com.ryl.learn.puzzlers;

public class T27 {

    public static void main(String[] args) {
        judgeBoolean();
    }

    private static void regexTest() {
        String a = "a1b2c3";
        String[] tokens = a.split("\\d");
        for (String s : tokens) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    private static void judgeBoolean () {

        Boolean aa = new Boolean(true);
        Boolean bb = new Boolean(true);
        System.out.println(aa == true); //自动拆箱
        System.out.println(bb == true);
        System.out.println(aa == Boolean.TRUE); //两个对象不相等
        System.out.println(aa == bb); //两个对象不相等

        if (aa) { //true
            System.out.println("this is true");
        }
    }

    private static void bitOperator() {
        int i = 0;
        while( -1 << i != 0){
            i++;
            System.out.println(i);
        }
        System.out.println(i);

        for (int val = -1; val != 0; val <<= 1) {
            i++;
        }
        System.out.println(i);
    }
}
