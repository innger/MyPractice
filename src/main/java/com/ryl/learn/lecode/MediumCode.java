package com.ryl.learn.lecode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created on 16/5/12 下午4:04.
 */
public class MediumCode {

    public static void main(String[] args) {
        MediumCode code = new MediumCode();


    }

    /**
     * 菲波那切数列
     * "112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
     * @param num string
     * @return true/false
     */
    public boolean isAdditiveNumber(String num) {
        return false;
    }

    /**
     * 二叉树前序遍历
     * @param root treeNode
     * @return list
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        // TODO: 16/5/13
        return null;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 开关灯,最后剩几盏灯亮着
     * @param n int
     * @return int
     */
    public int bulbSwitch(int n) {
        // TODO: 16/5/13
        return 0;
    }

    /**
     * Given two integers n and k,
     *
     * @param n 1 - n
     * @param k k
     * @return return all possible combinations of k numbers out of 1 ... n.
     */
    public List<List<Integer>> combine(int n, int k) {
        // TODO: 16/5/13
        return null;
    }

    /**
     * 求数组的组合
     * 1 - 2^n -1 的所有二进制形式
     * 要取得2^n,只需将0xFFFFFFFF左移32-n位,再右移回来即可
     *
     * @param chArr char[]
     * @return list
     */
    private List<String> combinationAll(char[] chArr) {
        int nCnt = chArr.length;
        int nBit = (0xFFFFFFFF >>> (32 - nCnt));
        List<String> list = new ArrayList<String>();
        for (int i = 1; i <= nBit; i++) {
            String str = "";
            for (int j = 0; j < nCnt; j++) {
                if ((i << (31 - j)) >> 31 == -1) {
                    str += chArr[j];
                }
            }
            list.add(str);
        }
        return list;
    }

    /**
     * find the maximum value of length(word[i]) * length(word[j])
     * where the two words do not share common letters
     * 二进制字母表标示,与操作判断是否为0
     *
     * @param words string[]
     * @return int
     * time limit
     */
    public int maxProduct(String[] words) {
        if (words == null || words.length < 2) {
            return 0;
        }
        int max = 0;
        //使用a-z数组判断两个字符串是否有重复
        String az = "abcdefghijklmnopqrstuvwxyz";
        int[] arr = new int[words.length]; //根据words转换成bits -> int
        for (int i = 0; i < words.length; i++) {
            int n = 0;
            for (char ch : words[i].toCharArray()) {
                int index = az.indexOf(ch);
                int tmp = 1;
                while (index >= 0) {
                    tmp = tmp << 1;
                    index--;
                }
                n = n | tmp;
            }
            arr[i] = n;
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                int n1 = arr[i];
                int n2 = arr[j];
                if ((n1 & n2) == 0) {
                    //没有重复字母
                    int len = words[i].length() * words[j].length();
                    max = max > len ? max : len;
                }
            }
        }
        return max;
    }


    /**
     * 输入数组
     * [0 - n-1] 的二进制表示,根据是否是1,判断是否输出
     *
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
            for (int b = 0; b < bits.length; b++) {
                if (bits[b] == 1) {
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
     *
     * @param n   输入数字
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
     *
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
