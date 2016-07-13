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
        System.out.println(code.canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(code.canJump(new int[]{3, 2, 1, 0, 4}));
    }

    /**
     * 144. Binary Tree Preorder Traversal
     *
     * @param root TreeNode
     * @return 二叉树的先序遍历
     */
    public List<Integer> preorderTraversal(TreeNode root) {
    // TODO: 16/7/13
        return null;
    }

    /**
     * 94. Binary Tree Inorder Traversal
     * Note: Recursive solution is trivial[微不足道的], could you do it iteratively?
     *
     * @param root TreeNode
     * @return List[Integer] 二叉树中序遍历
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        // TODO: 16/7/13
        return null;
    }

    /**
     * 55. Jump Game
     * Each element in the array represents your maximum jump length at that position.
     * Determine if you are able to reach the last index.
     * A = [2,3,1,1,4], return true.
     * A = [3,2,1,0,4], return false.
     * <p>
     * 动态规划的题目，保存一个当前最大可到达的距离maxreach，和一个当前这步可到达的距离比较,可以得到状态转移方程
     * max(maxreach, A[i] + i);
     * 遍历一遍数组，如果到某一步的时候最大距离并不能到这里，则说明不能走到最后，时间复杂度为O(N), 空间复杂度为O(1),
     *
     * @param nums int[]
     * @return true/false
     */
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return true;
        int maxreach = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (maxreach < i) return false;
            maxreach = Math.max(maxreach, nums[i] + i);
        }
        return true;
    }

    /**
     * 313. Super Ugly Number
     * Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k
     * 1 is a super ugly number for any given primes
     * The given numbers in primes are in ascending order
     * 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000
     * <p>
     * 和ugly number的思路差不多，都是保存给的几个素数在ugly序列中的位置，代表那个位置的ugly number乘以那个素数大于当前的数，
     * 这样每次就可以比较得到当前哪个相乘可以得到最小的ugly number.
     *
     * @param n      int
     * @param primes int[]
     * @return int 第n个super ugly number
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] arr = new int[n]; //ugly number array
        arr[0] = 1;
        int len = primes.length;
        int[] index = new int[len]; //针对primes元素的倍数
        for (int m = 1; m < n; m++) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < len; i++) {
                min = Math.min(arr[index[i]] * primes[i], min);
            }
            arr[m] = min;
            //更新index array
            for (int i = 0; i < len; i++) {
                while (arr[index[i]] * primes[i] <= min) {
                    index[i]++;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        return arr[n - 1];
    }

    /**
     * 53. Maximum Subarray
     * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
     * 连续子数组最大值
     *
     * @param nums int[]
     * @return int max
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int cur = nums[0];
        int max = cur;
        for (int i = 1; i < nums.length; i++) {
            if (cur < 0) {
                cur = 0;
            }
            cur = cur + nums[i];
            if (cur > max) {
                max = cur;
            }
        }
        return max;
    }

    /**
     * 113. Path Sum II
     * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
     *
     * @param root TreeNode
     * @param sum  int
     * @return List<List<Integer>>
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        // TODO: 16/7/7  
        return null;
    }

    /**
     * 166. Fraction to Recurring Decimal
     *
     * @param numerator   int 除数
     * @param denominator int 被除数
     * @return string 小数表示
     */
    public String fractionToDecimal(int numerator, int denominator) {
        // TODO: 16/7/12  
        return null;
    }

    /**
     * 306. Additive Number
     * <p>
     * 菲波那切数列
     * "112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
     * Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.
     * 确定第一个 第二个数,后续验证,可能超出Integer范围,使用string模拟大整数相加
     *
     * @param num string
     * @return true/false
     */
    public boolean isAdditiveNumber(String num) {
        int len = num.length();
        if (len < 3) return false;
        for (int i = 1; i <= len - 2; i++) {
            String num1 = num.substring(0, i);
            for (int j = i + 1; j <= len - 1; j++) {
                String num2 = num.substring(i, j);
                String num3 = num.substring(j);
                if (DFS(num1, num2, num3)) return true;
                if (num.charAt(i) == '0') break;
            }
            if (num.charAt(0) == '0') break;
        }
        return false;
    }

    //deep first search
    private boolean DFS(String num1, String num2, String num3) {
        if (num3.length() == 0) return true;
        String sum = addBigInteger(num1, num2);
        for (int i = 1; i <= num3.length(); i++) {
            String str = num3.substring(0, i);
            String term = num3.substring(i);
            if (str.equals(sum) && DFS(num2, str, term)) return true;
            if (num3.charAt(0) == '0') break;
        }
        return false;
    }


    private String addBigInteger(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        String sum = "";
        int flag = 0;
        while (len1 > 0 || len2 > 0) {
            int val = 0;
            if (len1 > 0) {
                val += num1.charAt(len1 - 1) - '0';
                len1--;
            }
            if (len2 > 0) {
                val += num2.charAt(len2 - 1) - '0';
                len2--;
            }
            sum = String.valueOf((val + flag) % 10) + sum;
            flag = (val + flag) / 10;
        }
        if (flag > 0) {
            sum = "1" + sum;
        }
        return sum;
    }

    /**
     * 开关灯,最后剩几盏灯亮着
     *
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
     * Given nums = [0, 1, 3] return 2.
     * 0-n find the missing number
     *
     * @param nums 输入数组
     * @return 丢失的数字
     */

    public int missingNumber(int[] nums) {
        int len = nums.length;
        int sum = ((len + 1) * len) / 2; //0 - n求和
        int tmp = 0;
        for (int n : nums) {
            tmp += n;
        }
        return sum - tmp;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
