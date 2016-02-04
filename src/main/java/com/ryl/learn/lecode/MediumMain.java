package com.ryl.learn.lecode;

import java.util.*;

/**
 * Created by renyulong on 16/2/3.
 */
public class MediumMain {

    public static void main(String[] args) {
        MediumMain main = new MediumMain();

        //-1, 0, 1, 2, -1, -4
        System.out.println(main.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int re = 0 - nums[i] - nums[j];
                Integer index = numMap.get(re);
                if (index != null && index != i && index != j) {
                    int max = nums[i] > nums[j] ? re > nums[i] ? re : nums[i] : re > nums[j] ? re : nums[j];
                    int min = nums[i] < nums[j] ? re < nums[i] ? re : nums[i] : re < nums[j] ? re : nums[j];
                    int mid = 0 - max - min;

                    List<Integer> subList = new ArrayList<Integer>(3);
                    subList.add(min);
                    subList.add(mid);
                    subList.add(max);
                    res.add(subList);
                } else {
                    numMap.put(nums[j]+nums[i], i+j);
                }
            }
        }
        return res;
    }

    public int threeSumClosest(int[] nums, int target) {
        int res = Integer.MAX_VALUE;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int tmp = nums[i] + nums[j] + nums[k];
                    int newDiff = Math.abs(tmp - target);
                    if (newDiff < diff) {
                        diff = newDiff;
                        res = tmp;
                        if (res == target) {
                            return res;
                        }
                    }
                }
            }
        }
        return res;
    }
}
