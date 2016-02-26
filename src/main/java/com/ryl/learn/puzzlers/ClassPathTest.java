package com.ryl.learn.puzzlers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClassPathTest {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));
        System.out.println(ClassPathTest.class.getResource(""));
        System.out.println(ClassPathTest.class.getResource("/"));
        System.out.println(addN(10));
        System.out.println(tailRecursiveAddn(10, 0));

        Integer a = 111;
        Integer b = 222;
        Integer c = 333;
        Integer d = 333;
        System.out.println(c == (d + 0));

        System.out.println(recursivePower(5));
        allSubs(new char[]{'a', 'b', 'c'});
        List<String> list = new ArrayList<String>();
        while (true) {
            String string = new String("123");
            list.add(string);
        }
    }

    public static int addN(int n) {
        return n == 1 ? 1 : n + addN(n - 1);
    }

    public static int tailRecursiveAddn(int n, int acc) {
        if (n == 0)
            return acc;
        return tailRecursiveAddn(n - 1, acc + n);
    }

    public static void allSubs(char[] str) {
        int num = recursivePower(str.length);
        int[] array = new int[str.length];
        Arrays.fill(array, 0);
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[j] == 0) {
                    array[j] = 1;
                    break;
                } else {
                    array[j] = 0;
                }
            }

            for (int j = 0; j < array.length; j++) {
                if (array[j] == 1) {
                    System.out.print(str[j]);
                }
            }
            System.out.println("--------");
        }
    }

    //计算2 的n次方 
    private static int recursivePower(int n) {
        if (n == 1)
            return 2;
        else {
            if ((n & 0x01) == 1) {
                return 2 * recursivePower(n / 2) * recursivePower(n / 2);
            } else {
                return recursivePower(n / 2) * recursivePower(n / 2);
            }
        }
    }
}	
