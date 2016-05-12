package com.ryl.learn.lecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created on 16/5/12 下午4:04.
 */
public class MediumCode {

    public static void main(String[] args) {
        MediumCode code = new MediumCode();
        System.out.println(code.subsets(new int[]{4,1,0}));
    }


    /**
     * 输入数组
     * [0 - n-1] 的二进制表示,根据是否是1,判断是否输出
     * @param nums 输入数组
     * @return 该数组的所有子序列 power(2,len(nums))个子序列
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int len = nums.length;
        int num = (int) (Math.pow(2, len));
        for (int i = 0; i < num; i++) {
            List<Integer> list = new ArrayList<Integer>();
            int[] bits = convertToBitArray(i, len);
            for(int b = 0 ; b < bits.length ;b++) {
                if(bits[b] == 1) {
                    list.add(nums[b]);
                }
            }
            Collections.sort(list);
            result.add(list);
        }
        return result;
    }

    /**
     * 将n转换成二进制表示 3 = [1,1,0]
     * @param n 输入数字
     * @param len 数组长度
     * @return int[]
     */
    private int[] convertToBitArray(int n, int len) {
        int[] arr = new int[len];
        int i = 0;
        while (n > 0) {
            int bit = n & 1;
            arr[i] = bit;
            i++;
            n = n >> 1;
        }
        return arr;
    }

    /**
     * Given nums = [0, 1, 3] return 2. 0-n find the missing number
     * @param nums 输入数组
     * @return 丢失的数字
     */
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int sum = ((len + 1) * len) / 2; //0-n求和
        int tmp = 0;
        for (int n : nums) {
            tmp += n;
        }
        return sum - tmp;
    }
}
