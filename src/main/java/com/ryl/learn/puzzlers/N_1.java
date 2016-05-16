package com.ryl.learn.puzzlers;

import java.util.Arrays;

public class N_1 {

    private static boolean judge(int[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int index = i;
            while (true) {
                int value = a[index];
                if (value < 0 || value > N - 1) {
                    return false;
                }
                if (a[value] == i) {
                    a[value] = -1;
                    break;
                }
                index = a[value];
                a[value] = -1;
            }
        }
        return true;
    }

    /**
     * 将数组置反,如果出现负数或者多个0,则返回false
     * @param a int[]
     * @return true/false
     */
    private static boolean setConverse(int[] a) {
        int N = a.length;
        int zero = 0; //取反 防止出现多个0
        for (int i = 0; i < N; i++) {
            int value = a[i];
            int index = value > 0 ? value : (0 - value);
            if (index > N - 1 || a[index] < 0)
                return false;
            if (a[index] == 0) {
                zero++;
            }
            if (zero > 1)
                return false;
            a[index] = -a[index];
        }
        System.out.println(Arrays.toString(a));
        return true;
    }

    public static void main(String[] args) {
        System.out.println(setConverse(new int[]{2, 3, 0, 1, 4}));
    }
}
