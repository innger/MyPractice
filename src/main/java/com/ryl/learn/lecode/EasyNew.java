package com.ryl.learn.lecode;

import java.util.ArrayList;
import java.util.List;

/**
 * Easy code 003
 * Created on 17/1/22 09:48.
 */
public class EasyNew {
    
    public static void main(String[] args) {
        EasyNew easyNew = new EasyNew();
        System.out.println(easyNew.hammingDistance(1, 4));
        System.out.println(easyNew.hammingWeight(-1));
        
        System.out.println(easyNew.findComplement(1));
        System.out.println(easyNew.findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0, 1}));
        
        System.out.println(easyNew.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        System.out.println(easyNew.findDisappearedNumbers(new int[]{1, 1}));
        
    }
    
    
    /**
     * 455. Assign Cookies
     * 数组s与g对比,满足s中数字大于等于g中数字的最多个数
     * 
     * @param g int[] 
     * @param s int[]
     * @return int
     */
    public int findContentChildren(int[] g, int[] s) {
        // TODO: 17/1/23  
        return 1;
    }
    
    /**
     * 448. Find All Numbers Disappeared in an Array
     * 数组中某些数字出现两次,或者一次
     * 找出未在数组中出现的全部数字,数组中数字本身也是index
     * Input:
     * [4,3,2,7,8,2,3,1] 
     * Output:
     * [5,6]
     *
     * @param nums int[] 1 ≤ a[i] ≤ n (n = size of array)
     * @return list Integer
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        int i = 0;
        while (i < len) {
            int n = nums[i];
            if (n == 0) {
                i++;
            } else {
                while (n != 0) {
                    int j = n - 1;
                    n = nums[j];
                    if (nums[j] == 0) {
                        i++;
                        break;
                    }
                    nums[j] = 0;
                }
            }
        }
        //数组中不为零数字index+1为缺失的数字
        List<Integer> result = new ArrayList<>();
        for (int j = 0; j < len; j++) {
            if (nums[j] != 0) {
                result.add(j + 1);
            }
        }
        return result;
    }
    
    /**
     * 485. Max Consecutive Ones
     * 给出一个二进制数组,里面是0,1,找出连续1组成的最大数
     * [1,1,0,1,1,1] return 3
     * 数组长度不超过10,000
     *
     * @param nums int[] binary array
     * @return int
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        //遍历一遍,找出最长连续1的个数
        int max = 0;
        int cur = 0;
        for (int n : nums) {
            if (n == 0) {
                max = cur > max ? cur : max;
                cur = 0;
            } else {
                cur++;
            }
        }
        return cur > max ? cur : max;
    }
    
    /**
     * 476. Number Complement
     * 求num的补码,翻转各位上的0和1
     * <p>
     * Note:
     * 1, The given integer is guaranteed to fit within the range of a 32-bit signed integer. 32位有符号数
     * 2, You could assume no leading zero bit in the integer’s binary representation.
     *
     * @param num int
     * @return int
     */
    public int findComplement(int num) {
        byte[] bits = new byte[32];
        int n = 32;
        //转换成二进制表示
        while (n > 0) {
            int i = (num >> (n - 1)) & 1;
            bits[32 - n] = ((byte) (i));
            n--;
        }
        boolean first = false;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (first || bits[i] == 1) {
                first = true;
                byte b = (byte) (bits[i] ^ 1);
                if (b == 1) {
                    res = res | (1 << (31 - i));
                }
            }
        }
        return res;
    }
    
    /**
     * 461. Hamming Distance
     * 计算两个整数的汉明码,各位二进制0,1不同的位数
     * 0 <= x,y < 2^31
     *
     * @param x int 1
     * @param y int 4
     * @return int 2
     */
    public int hammingDistance(int x, int y) {
        return hammingWeight(x ^ y);
    }
    
    private int hammingWeight(int n) {
        int cnt = 0;
        while (n > 0) {
            cnt++;
            n = (n - 1) & n;
        }
        return cnt;
    }
    
}
