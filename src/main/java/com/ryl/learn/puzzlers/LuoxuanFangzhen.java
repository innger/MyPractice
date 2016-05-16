package com.ryl.learn.puzzlers;

import java.util.Scanner;

/**
 * 螺旋方阵
 * 1      2      3      4       5
 * 16     17     18     19      6
 * 15     24     25     20      7
 * 14     23     22     21      8
 * 13     12     11     10      9
 */
public class LuoxuanFangzhen {

    public int getNum(int n, int i, int j) {
        if (i == 0)
            return j + 1;
        else if (i == n - 1)
            return 3 * n - j - 2;
        else if (j == 0)
            return 4 * n - i - 3;
        else if (j == n - 1)
            return n + i;
        else
            return 4 * (n - 1) + getNum(n - 2, i - 1, j - 1);
    }

    public void print(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.printf("%7d", getNum(n, i, j));
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("input a integer(0 to exit):");
            int n = scan.nextInt();
            if (n <= 0) break;
            new LuoxuanFangzhen().print(n);
        }
    }
}
