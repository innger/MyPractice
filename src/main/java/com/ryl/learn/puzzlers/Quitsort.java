package com.ryl.learn.puzzlers;

import org.junit.Test;

import java.util.Arrays;

public class Quitsort {

    public static void main(String[] args) {
        int[] a = {1, 4, 54, 6, 76, 8, 98};
        qsort1(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
        System.out.println("aaaabbbcd".contains("cd"));
        System.out.println(isContains("aaaabbbcd", "cd"));
        System.out.println(sumArray(new int[]{1, 2, 3, 4, 5}, 5));
        String str = "123";
        changeString(str);
        System.out.println(str);

        int i = 0;
        for (foo('A'); foo('B') && (i < 2); foo('C')) {
            i++;
            foo('D');
        }
        //ABDCBDCB
        System.out.println(computeNo0());
        System.out.println(compute0());

        System.out.println(addWithout(100, 25));

        System.out.println(add1_n(100));
        System.out.println(find(100));
        System.out.println(add1_n1(100));
    }

    public static void changeString(String str) {
        str = "welcome";
    }

    public static boolean foo(char c) {
        System.out.println(c);
        return true;
    }
    
    @Test
    public void qsortTest() {
        int[] arr = new int[]{7, 2, 3, 5, 9, 10};
        qsort1(arr, 0, 5);
    }

    public static void qsort1(int[] a, int p, int r) {
        if (p >= r)
            return;
        int x = a[p];
        int j = p;
        for (int i = p + 1; i <= r; i++) {
            if (a[i] < x) {
                j++;
                swap(a, j, i);
            }
        }
        swap(a, p, j);
        System.out.println(Arrays.toString(a));
        qsort1(a, p, j - 1);
        qsort1(a, j + 1, r);
    }

    public static void swap(int[] a, int l, int r) {
        int temp = a[l];
        a[l] = a[r];
        a[r] = temp;
    }

    public static boolean isContains(String big, String small) {
        for (int i = 0; i < big.length() - small.length() + 1; i++) {
            int k = i;
            int j = 0;
            for (j = 0; j < small.length(); j++) {
                if (big.charAt(k) != small.charAt(j)) {
                    break;
                }
                k++;
            }
            if (j == small.length()) {
                return true;
            }
        }
        return false;
    }

    public static int sumArray(int[] a, int n) {
        return n == 0 ? 0 : sumArray(a, n - 1) + a[n - 1];
    }

    //计算1000！ 有多少个0 
    //分解后的整个因数式中有多少对(2,   5)，结果中就有多少个0，而分解的结果中，2的个数显然是多于5的，因此，有多少个5，就有多少个(2,   5)对
    public static int computeNo0() {
        int count = 0;
        for (int i = 1000; i > 0; i -= 5) {
            int tmp = i;
            while (tmp % 5 == 0) {
                tmp = tmp / 5;
                count++;
            }
        }
        return count;
    }

    public static int compute0() {
        return 1000 / 5 + 1000 / 25 + 1000 / 125 + 1000 / 625;
    }

    public static int addWithout(int num1, int num2) {
        if (num2 == 0)
            return num1;
        int sum = num1 ^ num2;
        int carry = (num1 & num2) << 1;
        return addWithout(sum, carry);
    }

    static int add1_n1(int n) {
        return n == 0 ? 0 : n + add1_n1(n - 1);
    }

    public static int add1_n(int n) {
        int ret = n;
        boolean flag = true;
        int temp = 0;
        flag = (n != 0) && (temp == (ret = add1_n(n - 1)));
        return ret + n;
    }

    static int find(int n) {
        int re = 0;
        boolean whatever = false;
        int a = -1;
        whatever = (n != 0) && (a == (re = find(n - 1)));
        return re + n;
    }

}
