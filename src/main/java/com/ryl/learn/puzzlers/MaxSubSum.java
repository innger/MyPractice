package com.ryl.learn.puzzlers;

public class MaxSubSum {

    //tongshi
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, -2, -3, 7, 4, -2};
        System.out.println(maxSubSum(arr));
    }

    static int maxSubSum(int[] a) {
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
