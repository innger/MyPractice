package com.ryl.learn.lecode;

import java.util.*;

/**
 * Created on 16/7/29 下午3:51.
 */
public class MediumImpl {


    public static void main(String[] args) {
        MediumImpl main = new MediumImpl();
        int c = main.coinChange(new int[]{1, 2, 4}, 11);
        System.out.println(c);
        System.out.println(main.grayCode(5));
        System.out.println(main.grayCodeBacktracking(5));

        Set<String> set = new HashSet<String>();
        set.add("hot");
        set.add("dot");
        set.add("dog");
        set.add("lot");
        set.add("log");
        System.out.println(main.ladderLength("hit","cog",set));
    }

    /**
     * 127. Word Ladder
     * find the length of shortest transformation sequence from beginWord to endWord
     * 1.Only one letter can be changed at a time
     * 2.Each intermediate word must exist in the word list
     *
     * @param beginWord string
     * @param endWord   string
     * @param wordList  set string
     * @return int
     */
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Queue<String> queue = new LinkedList<String>();
        queue.offer(beginWord);
        wordList.add(endWord);
        wordList.remove(beginWord);
        int dis = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i< size;i++) {
                String str = queue.poll();
                if(str.equals(endWord)) return dis;
                for(String neighbor : neighbors(str, wordList)) {
                    queue.offer(neighbor);
                }
            }
            dis++;
        }
        return 0;
    }

    //找出wordList 中与 s distance=1 的单词
    private List<String> neighbors(String s, Set<String> wordList) {
        List<String> res = new ArrayList<String>();
        if(wordList.isEmpty()) return res;
        for(int i = 0; i < s.length(); i++) {
            char[] chars = s.toCharArray();
            for(char ch = 'a'; ch <= 'z'; ch++) {
                chars[i] = ch;
                String word = new String(chars);
                if(wordList.isEmpty()) return res;
                if(wordList.remove(word)) {
                    res.add(word);
                }
            }
        }
        return res;
    }

    private boolean diff(String s1, String s2) {
        int diff = 0;
        int len = s1.length();
        for (int i = 0; i < len; i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            diff += (ch1 == ch2) ? 0 : 1;
        }
        return diff == 1;
    }

    /**
     * 89. Gray Code
     * The gray code is a binary numeral system where two successive values differ in only one bit.
     * 二进制计数,相邻连续两个数只有一位不同
     * Given a non-negative integer n representing the total number of bits in the code,
     * A gray code sequence must begin with 0.
     * input 2
     * 00 01 11 10
     * output [0, 1, 3, 2]
     * 0 ~ 2^n-1 重点是顺序 i ^ i >> 1
     * Great solution
     *
     * @param n int
     * @return list integer
     */
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 1 << n; i++) list.add(i ^ i >> 1);
        return list;
    }

    //Java 1ms Backtracking Solution
    public List<Integer> grayCodeBacktracking(int n) {
        List<Integer> res = new ArrayList<>();
        helper(new int[1], n - 1, res);
        return res;
    }

    private void helper(int[] val, int index, List<Integer> res) {
        if (index == -1) {
            res.add(val[0]);
            return;
        }
        helper(val, index - 1, res);
        val[0] ^= (1 << index);
        helper(val, index - 1, res);
    }

    /**
     * The purpose of this function is to convert an unsigned
     * binary number to reflected binary Gray code.
     * <p>
     * The operator >> is shift right. The operator ^ is exclusive or.
     */

    int binaryToGray(int num) {
        return (num >> 1) ^ num;
    }

    /**
     * The purpose of this function is to convert a reflected binary
     * Gray code number to a binary number.
     */
    int grayToBinary(int num) {
        int mask;
        for (mask = num >> 1; mask != 0; mask = mask >> 1) {
            num = num ^ mask;
        }
        return num;
    }

    private int bit2int(int[] bits) {
        if (bits == null || bits.length == 0) return 0;
        int res = 0;
        int len = bits.length;
        for (int i = 0; i < len; i++) {
            if (bits[i] == 1) {
                res += 1 << (len - i - 1);
            }
        }
        return res;
    }

    /**
     * 322. Coin Change
     * Write a function to compute the fewest number of coins that you need to make up that amount.
     * If that amount of money cannot be made up by any combination of the coins, return -1.
     * 使用最少的硬币个数,凑齐amount coins为硬币的面额
     *
     * @param coins  int[]
     * @param amount int
     * @return int
     */
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        Arrays.sort(coins);
        coinCount(amount, coins.length - 1, coins, 0);
        return total == Integer.MAX_VALUE ? -1 : total;
    }

    private int total = Integer.MAX_VALUE;

    private void coinCount(int amount, int index, int[] coins, int count) {
        if (index < 0 || count >= total - 1) return;
        int c = amount / coins[index];
        for (int i = c; i >= 0; i--) {
            int newCount = count + i;
            int rem = amount - i * coins[index];
            if (rem > 0 && newCount < total) {
                coinCount(rem, index - 1, coins, newCount);
            } else if (newCount < total) {
                total = newCount;
            } else if (newCount >= total - 1) {
                break;
            }
        }
    }

}
