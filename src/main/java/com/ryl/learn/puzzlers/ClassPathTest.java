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
        System.out.println(tailRecursiveAddN(10, 0));

        Integer a = 111;
        Integer b = 222;
        Integer c = 333;
        Integer d = 333;
        System.out.println(c == (d + 0));

        System.out.println("2^5="+recursivePower(5));

        char[] arr = new char[]{'a', 'b', 'c'};
        System.out.println("allSubs of " + Arrays.toString(arr));
        allSubs(arr);

    }

    /**
     * 递归法求 1+2+..+n
     * @param n int
     * @return addN result
     */
    public static int addN(int n) {
        return n == 1 ? 1 : n + addN(n - 1);
    }

    /**
     * 尾递归
     * @param n int
     * @param acc 0
     * @return 1+2+..+n
     */
    public static int tailRecursiveAddN(int n, int acc) {
        if (n == 0)
            return acc;
        return tailRecursiveAddN(n - 1, acc + n);
    }

    /**
     * 数组的所有子序列
     * 模拟二进制表示
     * @param str char[]
     */
    public static void allSubs(char[] str) {
        int num = recursivePower(str.length);
        int[] array = new int[str.length];
        Arrays.fill(array, 0); //int[]默认是0
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
            System.out.println();
        }
    }

    /**
     * 递归计算2的n次方
     * @param n int
     * @return 2^n
     */
    private static int recursivePower(int n) {
        if(n == 0) {
            //2^0 = 1
            return 1;
        }
        if (n == 1)
            //2^1 = 2
            return 2;
        else {
            if ((n & 0x01) == 1) {
                //奇数
                return 2 * recursivePower(n / 2) * recursivePower(n / 2);
            } else {
                return recursivePower(n / 2) * recursivePower(n / 2);
            }
        }
    }
}	
