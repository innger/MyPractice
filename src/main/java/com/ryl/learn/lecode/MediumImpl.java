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
        System.out.println(main.ladderLength("hit", "cog", set));
        System.out.println(Arrays.toString(main.twoSum(new int[]{2, 7, 11, 15}, 9)));
//        System.out.println(main.divide(-2147483648,-1));
        System.out.println(main.divide(12, 2));
        char[][] grid = new char[4][5];
        grid[0] = new char[]{'1', '1', '0', '0', '0'};
        grid[1] = new char[]{'1', '1', '0', '0', '0'};
        grid[2] = new char[]{'0', '0', '1', '0', '0'};
        grid[3] = new char[]{'0', '0', '0', '1', '1'};
        System.out.println("##" + main.numIslands(grid));
    }

    /**
     * 200. Number of Islands
     * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
     * You may assume all four edges of the grid are all surrounded by water.
     * 被0围起来的小岛数
     * 1的个数,再判断1是否连接
     * 11110
     * 11010
     * 11000
     * 00000 answer:1
     * <p>
     * 11000
     * 11000
     * 00100
     * 00011 answer:3
     * Depth-first search | Breadth-first search | UnionFind
     *
     * @param grid char[][]
     * @return int
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        UF uf = new UF(m, n, grid);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') continue;
                int p = i * n + j;
                int q;
                if (i > 0 && grid[i - 1][j] == '1') {
                    q = p - n;
                    uf.union(p, q);
                }
                if (i < m - 1 && grid[i + 1][j] == '1') {
                    q = p + n;
                    uf.union(p, q);
                }
                if (j > 0 && grid[i][j - 1] == '1') {
                    q = p - 1;
                    uf.union(p, q);
                }
                if (j < n - 1 && grid[i][j + 1] == '1') {
                    q = p + 1;
                    uf.union(p, q);
                }
            }
        }
        return uf.count;
    }

    class UF {
        public int count = 0;
        public int[] id = null;

        public UF(int m, int n, char[][] grid) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') count++;
                }
            }
            int len = m * n;
            id = new int[len];
            for (int i = 0; i < len; i++) {
                id[i] = i;
            }
        }

        public int find(int p) {
            while (p != id[p]) {
                id[p] = id[id[p]];
                p = id[p];
            }
            return p;
        }

        public boolean isConnected(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            return pRoot == qRoot;
        }

        public void union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot) return;
            id[pRoot] = qRoot;
            count--;
        }
    }


    /**
     * 130. Surrounded Regions
     * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
     * A region is captured by flipping all 'O's into 'X's in that surrounded region.
     * 被'X'包围的'0'替换成'X'
     *
     * @param board char[][]
     */
    public void solve(char[][] board) {
        // TODO: 16/8/30
    }

    /**
     * 91. Decode Ways
     * A message containing letters from A-Z is being encoded to numbers using the following mapping:
     * 'A' -> 1
     * 'B' -> 2
     * ...
     * 'Z' -> 26
     * Given an encoded message containing digits, determine the total number of ways to decode it.
     * Dynamic Programming
     *
     * @param s string
     * @return int
     */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        int[] memo = new int[n + 1];
        memo[n] = 1;
        memo[n - 1] = s.charAt(n - 1) != '0' ? 1 : 0;
        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) != '0') {
                memo[i] = (Integer.parseInt(s.substring(i, i + 2)) <= 26) ? memo[i + 1] + memo[i + 2] : memo[i + 1];
            }
        }
        return memo[0];
    }

    /**
     * 29. Divide Two Integers
     * Divide two integers without using multiplication, division and mod operator.
     * If it is overflow, return MAX_INT.
     *
     * @param dividend int 除数
     * @param divisor  int 被除数
     * @return int
     */
    public int divide(int dividend, int divisor) {
        int sign = dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0 ? -1 : 1;
        long did = Math.abs((long) dividend);
        long dir = Math.abs((long) divisor);
        if (dir == 0) return Integer.MAX_VALUE;
        if (did == 0 || did < dir) return 0;

        long lans = longDivide(did, dir);
        int ans;
        if (lans > Integer.MAX_VALUE) {
            ans = (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            ans = (int) (sign * lans);
        }
        return ans;
    }

    //二分查找递归
    private long longDivide(long did, long dir) {
        if (did < dir) return 0L;
        long sum = dir;
        long multiple = 1;
        while ((sum + sum) <= did) {
            sum += sum;
            multiple += multiple;
        }
        return multiple + longDivide(did - sum, dir);
    }

    /**
     * 167. Two Sum II - Input array is sorted
     * the array is already sorted in ascending order
     * <p>
     * Input: numbers={2, 7, 11, 15}, target=9
     * Output: index1=1, index2=2
     * Please note that your returned answers (both index1 and index2) are not zero-based.
     * index 从1开始计数
     * 这居然是medium,感觉还没有Two Sum I(easy 数组没有排序) difficult
     *
     * @param numbers int[]
     * @param target  int
     * @return int[]
     */
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            long sum = numbers[i] + numbers[j];
            if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            } else {
                return new int[]{i + 1, j + 1};
            }
        }
        return new int[]{-1, -1};
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
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                if (str.equals(endWord)) return dis;
                for (String neighbor : neighbors(str, wordList)) {
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
        if (wordList.isEmpty()) return res;
        for (int i = 0; i < s.length(); i++) {
            char[] chars = s.toCharArray();
            for (char ch = 'a'; ch <= 'z'; ch++) {
                chars[i] = ch;
                String word = new String(chars);
                if (wordList.isEmpty()) return res;
                if (wordList.remove(word)) {
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
