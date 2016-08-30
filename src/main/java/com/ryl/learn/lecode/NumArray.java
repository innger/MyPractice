package com.ryl.learn.lecode;

/**
 * 303. Range Sum Query - Immutable
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 *
 * https://leetcode.com/problems/range-sum-query-immutable/
 * 参考 http://my.oschina.net/Tsybius2014/blog/528708
 * Created by renyulong on 16/2/18.
 */
public class NumArray {

    private int[] sums; //nums 从0-i的sum值 空间换时间

    //在构造函数中提前计算好sum
    public NumArray(int[] nums) {
        if (nums == null) {
            this.sums = null;
        } else if (nums.length == 0) {
            this.sums = new int[0];
        } else {
            this.sums = new int[nums.length];
            sums[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                sums[i] = sums[i - 1] + nums[i];
            }
        }
    }


    public int sumRange(int i, int j) {
        if (sums == null || i > sums.length - 1 || j > sums.length - 1 || i > j)
            return 0;
        if (i == 0) {
            return sums[j];
        }
        return sums[j] - sums[i - 1];
    }


}
