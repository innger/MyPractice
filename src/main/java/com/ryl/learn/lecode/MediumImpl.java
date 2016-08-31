package com.ryl.learn.lecode;

import com.google.common.collect.Lists;

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
        System.out.println(main.divide(-2147483648, -1));
        System.out.println(main.divide(12, 2));
        char[][] grid = new char[4][5];
        grid[0] = new char[]{'1', '1', '0', '0', '0'};
        grid[1] = new char[]{'1', '1', '0', '0', '0'};
        grid[2] = new char[]{'0', '0', '1', '0', '0'};
        grid[3] = new char[]{'0', '0', '0', '1', '1'};
        System.out.println("##" + main.numIslands(grid));

        System.out.println(main.restoreIpAddresses("25525511135"));

        System.out.println(main.simplifyPath("/../"));
        System.out.println(main.simplifyPath("/home/"));
        System.out.println(main.simplifyPath("/home//foo/"));
        System.out.println(main.simplifyPath("/a/./b/../../c/"));

        Set<String> wordDict = new HashSet<String>();
        String[] arr = new String[]{"cbc", "bcda", "adb", "ddca", "bad", "bbb", "dad", "dac", "ba", "aa", "bd", "abab", "bb", "dbda", "cb", "caccc", "d", "dd", "aadb", "cc", "b", "bcc", "bcd", "cd", "cbca", "bbd", "ddd", "dabb", "ab", "acd", "a", "bbcc", "cdcbd", "cada", "dbca", "ac", "abacd", "cba", "cdb", "dbac", "aada", "cdcda", "cdc", "dbc", "dbcb", "bdb", "ddbdd", "cadaa", "ddbc", "babb"};
        wordDict.addAll(Lists.newArrayList(arr));
        System.out.println(wordDict);
        System.out.println(main.wordBreak("bccdbacdbdacddabbaaaadababadad", wordDict));
        System.out.println(main.wordBreak2("bccdbacdbdacddabbaaaadababadad", wordDict));
//        System.out.println(main.majorityElement(new int[]{3,3,4}));
//        System.out.println(main.majorityElement(new int[]{3,2,3}));
//        System.out.println(main.majorityElement(new int[]{1,2}));
        System.out.println(main.majorityElement(new int[]{1, 1, 1, 3, 3, 2, 2, 2}));

        System.out.println(main.searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(main.searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(main.searchInsert(new int[]{1, 3, 5, 6}, 7));
        System.out.println(main.searchInsert(new int[]{1, 3, 5, 6}, 0));
        System.out.println(main.searchInsert(new int[]{1, 3}, 2));
        System.out.println(main.searchInsert(new int[]{1, 2, 3, 4, 5, 10}, 2));
        System.out.println(main.searchInsert(new int[]{1, 3, 5}, 2));

        System.out.println(Arrays.toString(main.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(main.searchRange(new int[]{2, 2}, 2)));
        System.out.println(Arrays.toString(main.searchRange(new int[]{1}, 1)));

        System.out.println(main.hIndexI(new int[]{3, 0, 6, 1, 5}));
    }

    /**
     * 275. H-Index II
     *
     * @param citations int[]
     * @return int
     */
    public int hIndexII(int[] citations) {
        // TODO: 16/8/31
        return 0;
    }

    /**
     * 274. H-Index
     * Given an array of citations (each citation(引用因子) is a non-negative integer) of a researcher
     * write a function to compute the researcher's h-index.
     * A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each
     *
     * @param citations int[]
     * @return int
     */
    public int hIndexI(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        Arrays.sort(citations);
        int len = citations.length;
        for (int i = 0; i < citations.length; i++) {
            if (len <= citations[i]) {
                return len;
            } else {
                len--;
            }
        }
        return len;
    }

    /**
     * 34. Search for a Range
     * Given a sorted array of integers, find the starting and ending position of a given target value.
     * O(log n)
     * If the target is not found in the array, return [-1, -1].
     * [5, 7, 7, 8, 8, 10] 8 return [3,4]
     *
     * @param nums   int[]
     * @param target int
     * @return int[]
     */
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums == null || nums.length == 0 || target < nums[0] || target > nums[nums.length - 1]) {
            return res;
        }
        int i = 0;
        int j = nums.length - 1;
        int n = -1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] < target) {
                i = mid + 1;
            } else if (nums[mid] > target) {
                j = mid - 1;
            } else {
                n = mid;
                break;
            }
        }
        if (n == -1) return res;
        int begin = n;
        if (begin > 0) {
            while (begin >= 0 && nums[begin] == target) {
                begin--;
            }
            begin++;
        }
        int end = n;
        if (end < nums.length) {
            while (end < nums.length && nums[end] == target) {
                end++;
            }
            end--;
        }
        res[0] = begin;
        res[1] = end;
        return res;
    }

    /**
     * 35. Search Insert Position
     * Given a sorted array and a target value, return the index if the target is found.
     * If not, return the index where it would be if it were inserted in order.
     * [1,3,5,6], 5 → 2
     * [1,3,5,6], 2 → 1
     * [1,3,5,6], 7 → 4
     * [1,3,5,6], 0 → 0
     *
     * @param nums   int[]
     * @param target int
     * @return int
     */
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        if (target <= nums[0]) return 0;
        if (target > nums[nums.length - 1]) return nums.length;
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] < target) {
                i = mid + 1;
            } else if (nums[mid] > target) {
                j = mid - 1;
            } else {
                return mid;
            }
        }
        return nums[i] < target ? i + 1 : i;
    }

    /**
     * 229. Majority Element II
     * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
     * The algorithm should run in linear time and in O(1) space.
     * 找出出现次数超过n/3次的元素 最多有两个
     * <p>
     * Boyer-Moore Majority Vote algorithm
     *
     * @param nums int[]
     * @return list
     */
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) return result;
        if (nums.length == 1) {
            result.add(nums[0]);
            return result;
        }
        int count = nums.length / 3;
        int m = nums[0], mc = 1;
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == m) {
                mc++;
            } else {
                j = i;
                break;
            }
        }
        int n = nums[j], nc = 1;
        for (int i = j + 1; i < nums.length; i++) {
            int num = nums[i];
            if (num == m) {
                mc++;
            } else if (num == n) {
                nc++;
            } else if (mc == 0) {
                m = num;
                mc = 1;
            } else if (nc == 0) {
                n = num;
                nc = 1;
            } else {
                mc--;
                nc--;
            }
        }
        //mc nc 需要在nums中重新统计
        mc = 0;
        nc = 0;
        for (int num : nums) {
            if (num == m) mc++;
            else if (num == n) nc++;
        }
        if (mc > count) result.add(m);
        if (nc > count) result.add(n);
        return result;
    }

    /**
     * 139. Word Break
     * Given a string s and a dictionary of words dict,
     * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
     * DP
     *
     * @param s        string
     * @param wordDict set
     * @return boolen
     */
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0) return true;
        if (wordDict == null || wordDict.size() == 0) return false;
        boolean[] flag = new boolean[s.length() + 1];
        flag[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {
                if (word.length() <= i) {
                    if (flag[i - word.length()]) {
                        if (s.substring(i - word.length(), i).equals(word)) {
                            flag[i] = true;
                            break;
                        }
                    }
                }
            }
        }
        return flag[s.length()];
    }

    private boolean wordBreak2(String s, Set<String> wordDict) {
        boolean[] flag = new boolean[s.length() + 1];
        flag[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (flag[j] && wordDict.contains(s.substring(j, i))) {
                    flag[i] = true;
                    break;
                }
            }
        }
        return flag[s.length()];
    }

    /**
     * 71. Simplify Path
     * Given an absolute path for a file (Unix-style), simplify it.
     * Linux cd命令,到正确的路径
     * path = "/home/", => "/home"
     * path = "/a/./b/../../c/", => "/c"
     * bug-free
     *
     * @param path string
     * @return string
     */
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) return null;
        Stack<String> stack = new Stack<String>();
        String res = "";
        String[] arr = path.split("/+");
        for (String str : arr) {
            if ("".equals(str) || ".".equals(str)) {
                continue;
            }
            if ("..".equals(str)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(str);
            }
        }
        while (!stack.isEmpty()) {
            res = stack.pop() + "/" + res;
        }
        if (res.endsWith("/")) res = res.substring(0, res.length() - 1);
        return "/" + res;
    }

    /**
     * 93. Restore IP Addresses
     * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
     * Given "25525511135",
     * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
     *
     * @param s string
     * @return list
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        if (s == null || s.length() < 4) {
            return result;
        }
        int len = s.length();
        //3-loop divides the string s into 4 substring: s1, s2, s3, s4.
        for (int i = 1; i < 4 && i < len - 2; i++) {
            for (int j = i + 1; j < i + 4 && j < len - 1; j++) {
                for (int k = j + 1; k < j + 4 && k < len; k++) {
                    String s1 = s.substring(0, i);
                    String s2 = s.substring(i, j);
                    String s3 = s.substring(j, k);
                    String s4 = s.substring(k, len);
                    if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
                        //Check if each substring is valid.
                        result.add(s1 + "." + s2 + "." + s3 + "." + s4);
                    }
                }
            }
        }
        return result;
    }

    private boolean isValid(String s) {
        //ip每个字段是 0 - 255
        return !(s.length() > 3 || s.length() == 0 || (s.charAt(0) == '0' && s.length() > 1) || Integer.parseInt(s) > 255);
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
