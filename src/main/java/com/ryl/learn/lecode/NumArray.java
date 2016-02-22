package com.ryl.learn.lecode;

/**
 * Created by renyulong on 16/2/18.
 */
public class NumArray {

    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        if(nums == null || i > nums.length -1 || j > nums.length - 1)
            return 0;
        int sum = 0;
        for(int k = i;k<=j;k++){
            sum += nums[k];
        }
        return sum;
    }

}
