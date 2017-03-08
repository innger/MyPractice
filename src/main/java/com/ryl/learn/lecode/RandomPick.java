package com.ryl.learn.lecode;

import java.util.Random;

/**
 * 398. Random Pick Index
 * nums数字数组,可能包含重复数字
 * 给定target值,随机返回在数组中的index索引值,等概率返回
 * <p>
 * Created on 17/3/8 14:55.
 */
public class RandomPick {
    
    private int[] nums;
    private Random random;
    
    public RandomPick(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }
    
    public int pick(int target) {
        int index = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (random.nextInt(++count) == 0) {
                    index = i;
                }
            }
        }
        return index;
    }
    
    public static void main(String[] args) {
        int[] nums = new int[2];
        RandomPick obj = new RandomPick(nums);
        int param_1 = obj.pick(3);
        System.out.println(param_1);
    }
}
