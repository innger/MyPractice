package com.ryl.learn.puzzlers;

import java.util.Arrays;


public class ArrayTest {


    public static void main(String[] args) {
        int[][] a = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println(findN(a, 7));

        int[] test = {1, 1, 1, 1, 1, 2, 3, 4, 5, 6, 1};
        System.out.println(moreThanHalf(test));

        int[] test1 = {1, 12, 0, 4, 0, 0, 0, 2, 3, 0, 4};
        arrange(test1);
        System.out.println(Arrays.toString(test1));
    }

    static boolean findNRecursive(int[][] array, int n) {
        int a1 = array.length;
        int a2 = array[a1 - 1].length;
        if (a1 <= 0 || a2 <= 0)
            return false;
        if (array[a1 - 1][a2 - 1] == n)
            return true;

        findNRecursive(array, n);
        return false;
    }

    static boolean findN(int[][] array, int n) {
        int a1 = array.length;
        int a2 = array[a1 - 1].length;
        int i = 0;
        int j = a2 - 1;
        while (i < a1 && j > 0) {
            if (array[i][j] == n) {
                System.out.println(i + " : " + j);
                return true;
            }
            if (array[i][j] < n)
                i++;
                //必须是else if 否则下面的if 判断可能数组越界
            else if (array[i][j] > n)
                j--;
        }
        return false;
    }

    static int moreThanHalf(int[] array) {
        int curValue = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if (curValue == array[i])
                count++;
            else {
                count--;
                if (count == 0) {
                    curValue = array[i];
                    count = 1;
                }
            }
        }
        return curValue;
    }

    //
    static void arrange(int[] array) {
        // i 找不为0的数值 k 指向 0值
        for (int i = array.length - 1, k = array.length - 1; i >= 0; i--) {
            if (array[i] != 0) {
                if (array[k] == 0) {
                    array[k] = array[i];
                    array[i] = 0;
                }
                k--;
            }
        }
    }


}
