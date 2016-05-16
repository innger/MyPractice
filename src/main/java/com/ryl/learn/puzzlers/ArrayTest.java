package com.ryl.learn.puzzlers;

import java.util.Arrays;


public class ArrayTest {


    public static void main(String[] args) {
        ArrayTest arrayTest = new ArrayTest();
        int[][] a = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println(arrayTest.findN(a, 17));

        int[] test = {1, 1, 1, 1, 1, 2, 3, 4, 5, 6, 1};
        System.out.println(arrayTest.moreThanHalf(test));

        int[] test1 = {1, 12, 0, 4, 0, 0, 0, 2, 3, 0, 4};
        arrayTest.arrange(test1);
        System.out.println(Arrays.toString(test1));
    }

    public boolean findNRecursive(int[][] array, int n) {
        int a1 = array.length;
        int a2 = array[a1 - 1].length;
        if (a1 <= 0 || a2 <= 0)
            return false;
        if (array[a1 - 1][a2 - 1] == n)
            return true;
        findNRecursive(array, n);
        return false;
    }

    /**
     * 在二维数组中找到n,并打印位置,返回true,若不在则返回false
     * @param array int[][]
     * @param n target
     * @return true/false
     */
    public boolean findN(int[][] array, int n) {
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

    /**
     * 找出数组中多于半数的那个数
     * @param array int[]
     * @return int
     */
    public int moreThanHalf(int[] array) {
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

    /**
     * 数组中有零和非零,将所有零都移到最前面
     * @param array int[]
     */
    public void arrange(int[] array) {
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

    /**
     * 连续子数组最大值
     * @param a int[]
     * @return max
     */
    public int maxSubSum(int[] a) {
        if (a.length == 0)
            return 0;
        int currSum = a[0];
        int maxSum = a[0];
        for (int i = 1; i < a.length; i++) {
            currSum += a[i];
            if (currSum < 0)
                currSum = 0;
            if (maxSum < currSum)
                maxSum = currSum;
        }
        return maxSum;
    }


}
