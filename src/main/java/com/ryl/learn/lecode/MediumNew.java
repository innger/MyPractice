package com.ryl.learn.lecode;

import java.util.*;

/**
 * MediumNew Code
 * 理解+记忆 * 反复
 * 基础类的算法 不是过目不忘的,只做一遍过去跟没做其实一样,要反复
 * Created on 17/2/27 10:54.
 */
public class MediumNew {
    
    public static void main(String[] args) {
        MediumNew main = new MediumNew();
        System.out.println(main.findDuplicates(new int[]{1, 2, 2, 3, 4, 3}));
        System.out.println(Arrays.toString(main.nextGreaterElements(new int[]{1, 2, 1})));
        
        System.out.println(main.countBattleships(new char[][]{
                {'.', '.', 'X'},
                {'X', '.', '.'},
                {'.', 'X', '.'}}));
        
        System.out.println(main.numberOfArithmeticSlices(new int[]{1, 2, 3, 4}));
        System.out.println(Arrays.deepToString(main.reconstructQueue(new int[][]{
                {7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}
        })));
        
        System.out.println(main.canPartition(new int[]{1, 5, 11, 5, 2}));
        System.out.println(main.canPartition(new int[]{100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100}));
        System.out.println(main.canPartition(new int[]{18, 40, 62, 33, 83, 64, 10, 92, 67, 31, 42, 51, 10, 97, 41, 7, 82, 71, 80, 81, 41, 38, 88, 25, 38, 89, 24, 89, 90, 12, 97, 21, 22, 85, 11, 59, 83, 6, 51, 47, 32, 82, 83, 100, 29, 78, 36, 32, 1, 31, 36, 19, 35, 3, 36, 21, 24, 93, 42, 33, 10, 26, 2, 39, 36, 62, 85, 24, 41, 5, 66, 53, 7, 1, 59, 53, 40, 59, 41, 95, 7, 67, 20, 29, 80, 59, 49, 49, 51, 90, 13, 52, 6, 90, 5, 6, 31, 81, 95, 26}));
        
        System.out.println(main.findPoisonedDuration(new int[]{1, 4}, 2));
        System.out.println(main.findPoisonedDuration(new int[]{1, 2}, 2));
        
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1, 4));
        list.add(new Interval(0, 2));
        list.add(new Interval(3, 5));
        System.out.println(main.merge(list));
        
        list = new ArrayList<>();
        list.add(new Interval(1, 3));
        list.add(new Interval(8, 10));
        list.add(new Interval(2, 6));
        list.add(new Interval(15, 18));
        System.out.println(main.merge(list));
        
        list = new ArrayList<>();
        list.add(new Interval(2, 3));
        list.add(new Interval(4, 5));
        list.add(new Interval(6, 7));
        list.add(new Interval(8, 9));
        list.add(new Interval(1, 10));
        System.out.println(main.merge(list));
        
        list = new ArrayList<>();
        list.add(new Interval(1, 3));
        list.add(new Interval(0, 2));
        list.add(new Interval(2, 3));
        list.add(new Interval(4, 6));
        list.add(new Interval(4, 5));
        list.add(new Interval(5, 5));
        list.add(new Interval(0, 2));
        list.add(new Interval(3, 3));
        System.out.println(main.merge(list));
        
        System.out.println(main.totalHammingDistance(new int[]{4, 14, 2}));
        
        System.out.println(main.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
        System.out.println(main.findRepeatedDnaSequences("AAAAAAAAAAAA"));
        
        System.out.println(main.rangeBitwiseAnd(5, 7));
        System.out.println(main.rangeBitwiseAnd(600000000, 2147483645));
        
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
        System.out.printf("TreeNode root=" + root);
        System.out.println(main.findBottomLeftValue(root));
        
        System.out.println(Arrays.toString(main.findDiagonalOrder(new int[][]{
                {1, 2, 3, 4, 6, 7},
                {4, 5, 6, 7, 8, 9},
                {7, 8, 9, 4, 3, 1}
        })));
        
        System.out.println(Arrays.toString(main.findDiagonalOrder(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 0},
                {5, 9, 12},
                {6, 10, 13},
                {7, 11, 15}
        })));
        
        System.out.println(Arrays.toString(main.findDiagonalOrder(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 0},
        })));
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);
        
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(4);
        
        ListNode l = main.addTwoNumbers(l1, l2);
        while (l != null) {
            System.out.print(l.val + "->");
            l = l.next;
        }
        
        System.out.println(main.originalDigits("owoztneoer"));
        System.out.println(main.originalDigits("fviefuro"));
        
        System.out.println(main.subsets(new int[]{1, 2, 3}));
        System.out.println(Arrays.toString(main.bits(3)));
        
        System.out.println(main.validUtf8(new int[]{197, 130, 1}));
        System.out.println(main.validUtf8(new int[]{235, 140, 4}));
        System.out.println(main.licenseKeyFormatting("2-4A0r7-4k", 8));
        
        System.out.println(main.findStart(4, new int[]{1, 2, 3, 5, 6, 7, 8}, 7));
        
        System.out.println("findRightInterval " + Arrays.toString(main.findRightInterval2(new Interval[]{
                new Interval(1, 4), new Interval(2, 3), new Interval(3, 4)
        })));
        
        System.out.println(main.findPeakElement(new int[]{1, 2, 3, 1}));
        
        System.out.println(main.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(main.minSubArrayLen(4, new int[]{1, 4, 4}));
        
        int[] arr = new int[]{4, 5, 6, 7, 0, 1, 2};
        for (int i = 0; i < arr.length; i++) {
//            System.out.println("33. " + main.searchInRotatedSortedArray(arr, arr[i]));
        }
//        System.out.println("33. " + main.searchInRotatedSortedArray(arr, 3));
        System.out.println(main.searchInRotatedSortedArray(new int[]{1, 3}, 3));
        
        List<String> times = new ArrayList<>();
        times.add("23:59");
        times.add("00:00");
        System.out.println(main.findMinDifference(times));
        System.out.println(main.findMinDifference2(times));
        
        System.out.println(main.checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 6));
        
        System.out.println(main.generateParenthesis(3));
        
        System.out.println(main.decodeString("3[a2[cd]]"));
        System.out.println(main.decodeString("2[abc]3[cd]ef"));
        System.out.println(main.decodeString("100[leetcode]"));
        System.out.println(main.decodeString("sd2[f2[e]g]i"));
        System.out.println(main.lexicalOrder3(10));
        
        System.out.println(main.canPartition(new int[]{1, 5, 11, 5, 2}));
        System.out.println(main.canPartition(new int[]{100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100}));
        System.out.println(main.canPartition(new int[]{18, 40, 62, 33, 83, 64, 10, 92, 67, 31, 42, 51, 10, 97, 41, 7, 82, 71, 80, 81, 41, 38, 88, 25, 38, 89, 24, 89, 90, 12, 97, 21, 22, 85, 11, 59, 83, 6, 51, 47, 32, 82, 83, 100, 29, 78, 36, 32, 1, 31, 36, 19, 35, 3, 36, 21, 24, 93, 42, 33, 10, 26, 2, 39, 36, 62, 85, 24, 41, 5, 66, 53, 7, 1, 59, 53, 40, 59, 41, 95, 7, 67, 20, 29, 80, 59, 49, 49, 51, 90, 13, 52, 6, 90, 5, 6, 31, 81, 95, 26}));
        
    }
    
    /**
     * 416. Partition Equal Subset Sum
     * 是否可以分成两个subSet 两个子数组和相等
     * input: [1, 5, 11, 5]
     * output: true [1, 5, 5] [11]
     * <p>
     * input: [1, 2, 3, 5]
     * output: false
     * 数组和为偶数,并且找出subSet和等于sum/2
     * 是否存在子数组和为sum/2,不是连续子数组
     *
     * @param nums int[] 正整数数组
     * @return true/false
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        return (sum & 1) == 0 && isEqualSum(nums, sum >> 1); //sum/2
    }
    
    /**
     * dp动态规划,判断数组中是否存在子数组和等于给定的sum
     */
    private boolean isEqualSum(int[] nums, int sum) {
        boolean[] dp = new boolean[sum + 1]; //存所有子数组和的可能值
        dp[0] = true;
        for (int n : nums) {
            for (int i = sum; i >= n; i--) {
                //i >= n 最小到n,当前遍历值
                dp[i] = dp[i] | dp[i - n];
            }
        }
        return dp[sum];
    }
    
    /**
     * 386. Lexicographical Numbers Add to List
     * 输出1-n的字母顺序排序
     * n=13, output : [1,10,11,12,13,2,3,4,5,6,7,8,9]
     * best solution!
     *
     * @param n int
     * @return list Integer
     */
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        int cur = 1;
        for (int i = 1; i <= n; i++) {
            list.add(cur);
            if (cur * 10 <= n) {
                cur *= 10;
            } else if (cur % 10 != 9 && cur + 1 <= n) {
                cur++;
            } else {
                while ((cur / 10) % 10 == 9) {
                    cur /= 10;
                }
                cur = cur / 10 + 1;
            }
        }
        return list;
    }
    
    public List<Integer> lexicalOrder2(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            dfs(i, n, list);
        }
        return list;
    }
    
    private void dfs(int cur, int n, List<Integer> res) {
        if (cur <= n) {
            res.add(cur);
            for (int i = 0; i < 10; i++) {
                if (10 * cur + i > n) {
                    return;
                }
                dfs(10 * cur + i, n, res);
            }
        }
    }
    
    public List<Integer> lexicalOrder3(int n) {
        List<Integer> result = new ArrayList<>();
        int cur = 1;
        for (int i = 0; i < n; i++) {
            result.add(cur);
            if (cur * 10 <= n) {
                cur *= 10;
            } else {
                if (cur >= n) {
                    cur /= 10;
                }
                cur++;
                while (cur % 10 == 0) {
                    cur /= 10;
                }
            }
        }
        return result;
    }
    
    /**
     * 394. Decode String
     * <p>
     * 编码规则 k[encoded_string] k是重复次数
     * 输入的encoded_string都是字符,只有k是数字
     * 3a or 2[4] 不会出现
     * 嵌套出现
     * s = "3[a2[c]]", return "accaccacc".
     * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
     * Depth-first search Stack
     *
     * @param s String
     * @return string
     */
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        Stack<String> stack = new Stack<>();
        int num = 0;
        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch == ']') {
                String sub = "";
                while (!stack.isEmpty()) {
                    String c = stack.pop();
                    if ("[".equals(c)) {
                        num--;
                        break;
                    }
                    sub = c + sub;
                }
                int cnt = Integer.valueOf(stack.pop());
                if (num > 0) {
                    for (int c = 0; c < cnt; c++) {
                        stack.push(sub);
                    }
                } else {
                    //num == 0,将之前的string添加到result中
                    while (!stack.isEmpty()) {
                        res.append(stack.pop());
                    }
                    for (int c = 0; c < cnt; c++) {
                        res.append(sub);
                    }
                }
                i++;
            } else if (ch == '[') {
                stack.push("[");
                num++;
                i++;
            } else if (ch >= '0' && ch <= '9') {
                StringBuilder sub = new StringBuilder();
                while (ch >= '0' && ch <= '9') {
                    sub.append(ch);
                    i++;
                    if (i == s.length()) {
                        break;
                    }
                    ch = s.charAt(i);
                }
                if (sub.length() > 0) {
                    stack.push(sub.toString());
                }
            } else if (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z') {
                StringBuilder sub = new StringBuilder();
                while (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z') {
                    sub.append(ch);
                    i++;
                    if (i == s.length()) {
                        break;
                    }
                    ch = s.charAt(i);
                }
                if (sub.length() > 0) {
                    stack.push(String.valueOf(sub));
                }
            }
        }
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return String.valueOf(res);
    }
    
    /**
     * 22. Generate Parentheses(括号)
     * 给出n对括号,输出所有合法的括号组合
     *
     * @param n int
     * @return list string
     */
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list, "", 0, 0, n);
        return list;
    }
    
    private void backtrack(List<String> list, String str, int open, int close, int max) {
        if (str.length() == 2 * max) {
            list.add(str);
            return;
        }
        if (open < max)
            backtrack(list, str + "(", open + 1, close, max);
        if (close < open)
            backtrack(list, str + ")", open, close + 1, max);
    }
    
    /**
     * 523. Continuous Subarray Sum
     * 是否存在连续子数组(最小长度2)和是k的倍数
     * Input: [23, 2, 4, 6, 7],  k=6 Output: True (2+4) / 6
     * Input: [23, 2, 6, 4, 7],  k=6 Output: True (23 + 2 + 6 + 4 + 7) / 6 ; (2 + 6 + 4) / 6
     *
     * @param nums int[] 非负整数,长度不超过10000,数组内全部和不会超过32位有符号整数
     * @param k    int
     * @return true/false
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>() {
            {
                put(0, -1);
            }
        };
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) sum %= k;
            Integer pre = map.get(sum);
            if (pre != null) {
                if (i - pre > 1) return true;
            } else {
                map.put(sum, i);
            }
        }
        return false;
    }
    
    /**
     * 539. Minimum Time Difference
     * 给出一组24小时制的Hour:Minutes格式的时间戳,找出其中任意两个相差最小的分钟数
     * Input: ["23:59","00:00"] Output: 1
     * <p>
     * 给定的时间都是合法的,并且在00:00 to 23:59之间
     *
     * @param timePoints list string 最少两个,最多不超过20000
     * @return int
     */
    public int findMinDifference(List<String> timePoints) {
        //一共24*60种可能,转换timePoints
        int total = 24 * 60;
        boolean[] mark = new boolean[total];
        for (String time : timePoints) {
            String[] t = time.split(":");
            int h = Integer.valueOf(t[0]);
            int m = Integer.valueOf(t[1]);
            if (mark[h * 60 + m]) return 0;
            mark[h * 60 + m] = true;
        }
        //求数组中true的相邻的最小值
        int pre = 0;
        int min = Integer.MAX_VALUE;
        int first = Integer.MAX_VALUE; //最后计算首尾时间差
        int last = Integer.MIN_VALUE;
        for (int i = 0; i < total; i++) {
            if (mark[i]) {
                if (first != Integer.MAX_VALUE) {
                    min = Math.min(min, i - pre);
                }
                first = Math.min(first, i);
                last = Math.max(last, i);
                pre = i;
            }
        }
        min = Math.min(min, total - (last - first));
        return min;
    }
    
    public int findMinDifference2(List<String> timePoints) {
        Collections.sort(timePoints);
        List<Integer> minutes = new ArrayList<>();
        for (String time : timePoints) {
            minutes.add(transformTime(time));
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < minutes.size(); i++) {
            min = Math.min(min, minutes.get(i) - minutes.get(i - 1));
        }
        int first = minutes.get(0);
        int last = minutes.get(minutes.size() - 1);
        min = Math.min(min, 24 * 60 - (last - first));
        return min;
    }
    
    private int transformTime(String time) {
        String[] arr = time.split(":");
        Integer hour = Integer.valueOf(arr[0]);
        Integer minu = Integer.valueOf(arr[1]);
        return hour * 60 + minu;
    }
    
    
    //60进制减法
    private int calDiffMinutes(String s1, String s2) {
        if (s1.equals(s2)) return 0;
        String[] arr1 = s1.split(":");
        String[] arr2 = s2.split(":");
        Integer hour1 = Integer.valueOf(arr1[0]);
        Integer minu1 = Integer.valueOf(arr1[1]);
        Integer hour2 = Integer.valueOf(arr2[0]);
        Integer minu2 = Integer.valueOf(arr2[1]);
        int minu = 0;
        if (minu2 >= minu1) {
            minu += minu2 - minu1;
        } else {
            hour2--;
            minu += (minu2 + 60) - minu1;
        }
        minu += (hour2 - hour1) * 60;
        return minu;
    }
    
    /**
     * 33. Search in Rotated Sorted Array
     * 递增数组从某个点翻转 0 1 2 4 5 6 7 -> 4 5 6 7 0 1 2
     * 二分查找
     *
     * @param nums   int[] 无重复数字
     * @param target int
     * @return int
     */
    public int searchInRotatedSortedArray(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return nums[0] == target ? 0 : -1;
        int len = nums.length;
        int low = 0;
        int high = len - 1;
        int mid;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == target) return mid;
            //这嵌套if判断 二分查找醉了 判断mid落在前后哪个区间
            if (nums[mid] >= nums[0]) {
                if (target > nums[mid]) {
                    low = mid + 1;
                } else {
                    if (target >= nums[0]) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
            } else {
                if (target < nums[mid]) {
                    high = mid - 1;
                } else {
                    if (target >= nums[0]) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
            }
        }
        return nums[low] == target ? low : -1;
    }
    
    /**
     * 209. Minimum Size Subarray Sum
     * 找出长度最短的连续子数组,sum ≥ s 如果不存在,返回0
     * [2,3,1,2,4,3] s=7, return 2 [4,3]
     *
     * @param s    int 正整数
     * @param nums int[] 正整数
     * @return int
     */
    public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1 && s == nums[0]) {
            return 1;
        }
        int i = 0;
        int sub = 1;
        int sum = nums[i];
        int min = Integer.MAX_VALUE;
        while (i < len) {
            if (sum == s) {
                min = Math.min(sub, min);
                i = i + ((sub - 1) == 0 ? 1 : sub - 1);
                if (i >= len) break;
                sum = nums[i];
                sub = 1;
            } else if (sum > s) {
                min = Math.min(sub, min);
                i++;
                sub = 1;
                if (i >= len) break;
                sum = nums[i];
            } else {
                if (i + sub >= len) break;
                sum += nums[i + sub];
                sub++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
    
    /**
     * 162. Find Peak Element
     * <p>
     * peak值比前后元素大
     * 数组中可能存在多个peak元素,返回其中任意一个的索引即可
     * num[-1] = num[n] = -∞ 数组两端元素是无穷小
     * [1, 2, 3, 1] return 2(index)
     * Sequential Search
     *
     * @param nums int[] num[i] ≠ num[i+1]
     * @return int
     */
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }
        if (nums[0] > nums[1]) {
            return 0;
        }
        for (int i = 1; i < len - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            }
        }
        if (nums[len - 1] > nums[len - 2]) {
            return len - 1;
        }
        return -1;
    }
    
    public int findPeakElement2(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                return i - 1;
            }
        }
        return nums.length - 1;
    }
    
    //Binary Search
    public int findPeakElement3(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid1 = low + (high - low) / 2;
            int mid2 = mid1 + 1;
            if (nums[mid1] < nums[mid2]) {
                low = mid2;
            } else {
                high = mid1;
            }
        }
        return low;
    }
    
    /**
     * 436. Find Right Interval
     * <p>
     * 区间j在区间i的右侧,j的start>=i的end,区间j和i没有交集
     * 对于每一个区间i,找出index最小的区间j
     * <p>
     * 1,每个区间的end > start
     * 2,全部的区间start均不相等 start排序,二分查找
     * <p>
     * Input: [ [1,2] ] Output: [-1]
     * Input: [ [3,4], [2,3], [1,2] ] Output: [-1, 0, 1]
     * Input: [ [1,4], [2,3], [3,4] ] Output: [-1, 2, -1]
     *
     * @param intervals Interval[]
     * @return int[]
     */
    public int[] findRightInterval(Interval[] intervals) {
        int len = intervals.length;
        int[] res = new int[len];
        if (len == 1) {
            res[0] = -1;
            return res;
        }
        int[] startArr = new int[len];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            startArr[i] = intervals[i].start;
            map.put(startArr[i], i);
        }
        Arrays.sort(startArr);
        for (int i = 0; i < len; i++) {
            int end = intervals[i].end;
            Integer start = findStart(end, startArr, len);
            int index = -1;
            if (start != null) {
                index = map.get(start);
            }
            res[i] = index;
        }
        return res;
    }
    
    //在一个有序数组中,找出最小的大于等于给定值
    private Integer findStart(int target, int[] arr, int len) {
        int i = 0;
        int j = len - 1;
        int mid;
        while (i < j) {
            mid = i + (j - i) / 2;
            if (arr[mid] > target) {
                j = mid - 1;
            } else if (arr[mid] < target) {
                i = mid + 1;
            } else {
                return target;
            }
        }
        while (i < len) {
            if (arr[i] >= target) {
                return arr[i];
            }
            i++;
        }
        return null;
    }
    
    //start end 分别排序,依次遍历查找
    public int[] findRightInterval2(Interval[] intervals) {
        int len = intervals.length;
        //start 不重复,当key
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(intervals[i].start, i);
        }
        Interval[] endIntervals = Arrays.copyOf(intervals, len);
        Arrays.sort(endIntervals, (i1, i2) -> i1.end - i2.end);
        Arrays.sort(intervals, (i1, i2) -> i1.start - i2.start);
        int[] res = new int[len];
        int end = 0;
        int start = 0;
        while (end < len) {
            while (start < len && endIntervals[end].end > intervals[start].start) {
                start++;
            }
            res[map.get(endIntervals[end].start)] = start == len ? -1 : map.get(intervals[start].start);
            end++;
        }
        return res;
    }
    
    //tree map
    public int[] findRightInterval3(Interval[] intervals) {
        int len = intervals.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < len; i++) {
            map.put(intervals[i].start, i);
        }
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            //ceilingEntry 现成函数
            Map.Entry<Integer, Integer> entry = map.ceilingEntry(intervals[i].end);
            res[i] = entry == null ? -1 : entry.getValue();
        }
        return res;
    }
    
    /**
     * 482. License Key Formatting
     * <p>
     * 序列号由数字/字母/-号/组成,-的位置可能是错放的
     * 重新格式化序列号,使每个分组长度=K,第一个分组例外,可以小于K 最少一个字符
     * 结果字母转换成大写
     * Input: S = "2-4A0r7-4k", K = 4 Output: "24A0-R74K"
     * Input: S = "2-4A0r7-4k", K = 3 Output: "24-A0R-74K"
     *
     * @param S String
     * @param K int 正整数
     * @return String
     */
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        int len = 0;
        for (char ch : S.toCharArray()) {
            if ('-' == ch) {
                continue;
            }
            if (ch >= 'a' && ch <= 'z') {
                sb.append((char) (ch - 32));
            } else {
                sb.append(ch);
            }
            len++;
        }
        int first = len % K;
        StringBuilder result = new StringBuilder();
        int index = 0;
        while (index < first) {
            result.append(sb.charAt(index));
            index++;
            if (index == first && index < len) {
                result.append('-');
            }
        }
        int k = 0;
        while (index < len) {
            result.append(sb.charAt(index));
            k++;
            index++;
            if (index < len && k % K == 0) {
                result.append('-');
                k = 0;
            }
        }
        return String.valueOf(result);
    }
    
    
    /**
     * 393. UTF-8 Validation
     * utf8编码规则,变长编码1-4字节
     * 0xxxxxxx
     * 110xxxxx 10xxxxxx
     * 1110xxxx 10xxxxxx 10xxxxxx
     * 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx 4字节编码,最高四位是1,第五位是0,后面每字节最高两位10
     * 数组中每个数字,代表编码的一字节8bits
     *
     * @param data int[]
     * @return true/false
     */
    public boolean validUtf8(int[] data) {
        if (data == null || data.length < 1) return false;
        for (int i = 0; i < data.length; i++) {
            int[] bits = bits(data[i]);
            int index = 0;
            if (bits[index] == 0) continue;
            if (bits[index] == 1) {
                index++;
                if (bits[index] == 0) return false;
                //11
                index++;
                if (bits[index] == 0) {
                    //110
                    if (i >= data.length - 1)
                        return false;
                    i++;
                    int[] bits2 = bits(data[i]);
                    if (!(bits2[0] == 1 && bits2[1] == 0))
                        return false;
                } else {
                    index++;
                    if (bits[index] == 0) {
                        //1110
                        if (i >= data.length - 2)
                            return false;
                        i++;
                        int[] bits2 = bits(data[i]);
                        i++;
                        int[] bits3 = bits(data[i]);
                        if (!(bits2[0] == 1 && bits2[1] == 0 && bits3[0] == 1 && bits3[1] == 0))
                            return false;
                    } else {
                        index++;
                        if (bits[index] == 0) {
                            //11110
                            if (i >= data.length - 3)
                                return false;
                            i++;
                            int[] bits2 = bits(data[i]);
                            i++;
                            int[] bits3 = bits(data[i]);
                            i++;
                            int[] bits4 = bits(data[i]);
                            if (!(bits2[0] == 1 && bits2[1] == 0 && bits3[0] == 1 && bits3[1] == 0
                                    && bits4[0] == 1 && bits4[1] == 0))
                                return false;
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    
    private int[] bits(int n) {
        int[] arr = new int[8];
        int i = arr.length - 1;
        while (i >= 0 && n > 0) {
            if ((n & 1) == 1) arr[i] = 1;
            n = n >> 1;
            i--;
        }
        return arr;
    }
    
    
    /**
     * 90. Subsets II
     * 返回所有子数组序列,不含有重复
     *
     * @param nums int[] duplicate number
     * @return list
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrackDup(list, new ArrayList<>(), nums, 0);
        return list;
    }
    
    private void backtrackDup(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            tempList.add(nums[i]);
            backtrackDup(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
    
    /**
     * 78. Subsets
     * 求数组的所有子集合,包含空 2^n个子集合
     * 0-2^n 二进制的表示
     *
     * @param nums int[] distinct numbers
     * @return list
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int len = (int) Math.pow(2, nums.length);
        for (int i = 0; i < len; i++) {
            List<Integer> position = positionOf1(i);
            List<Integer> list = new ArrayList<>();
            for (int p : position) {
                list.add(nums[p]);
            }
            result.add(list);
        }
        return result;
    }
    
    private List<Integer> positionOf1(int n) {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                list.add(i);
            }
            n = n >> 1;
            i++;
        }
        return list;
    }
    
    //Backtracking解法
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }
    
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
    
    /**
     * 31. Next Permutation
     * 找出下一个表示更大数字的全排列,
     * 1,2,3 → 1,3,2
     * 3,2,1 → 1,2,3 如果没有更大的,那找出最小的
     * 1,1,5 → 1,5,1
     *
     * @param nums int[]
     */
    public void nextPermutation(int[] nums) {
        
    }
    
    /**
     * 60. Permutation Sequence
     * 按照顺序输出第k个全排列
     *
     * @param n n will be between 1 and 9 inclusive.
     * @param k kth
     * @return 第k个全排列
     */
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>(); // 1 - n
        int[] factorial = new int[n + 1]; //n! = n * (n-1) * (n-2) .. * 1
        StringBuilder sb = new StringBuilder();
        int sum = 1;
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
            factorial[i] = sum;
        }
        
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        k--;
        //数学推导 clever
        for (int i = 1; i <= n; i++) {
            int index = k / factorial[n - i];
            sb.append(String.valueOf(numbers.get(index)));
            numbers.remove(index);
            k -= index * factorial[n - i];
        }
        return sb.toString();
    }
    
    /**
     * 531. Lonely Pixel I
     *
     * @param picture char[][]
     * @return int
     */
    public int findLonelyPixel(char[][] picture) {
        // TODO: 17/3/6  
        return 0;
    }
    
    /**
     * 423. Reconstruct Original Digits from English
     * 输入代表0-9乱序英文单词,输出升序的数字表示
     * Input: "owoztneoer" Output: "012"
     * Input: "fviefuro"  Output: "45"
     * 字符和数字的对应个数规律
     * 用map存每个字符出现的个数,再过滤,效率低下没有总结规律
     *
     * @param s String 全部小写字母
     * @return String
     */
    public String originalDigits(String s) {
        Map<String, String> digitMap = new HashMap<>();
        digitMap.put("zero", "0");
        digitMap.put("one", "1");
        digitMap.put("two", "2");
        digitMap.put("three", "3");
        digitMap.put("four", "4");
        digitMap.put("five", "5");
        digitMap.put("six", "6");
        digitMap.put("seven", "7");
        digitMap.put("eight", "8");
        digitMap.put("nine", "9");
        
        Map<Character, String> map = new HashMap<>();
        map.put('z', "zero");
        map.put('w', "two");
        map.put('u', "four");
        map.put('x', "six");
        map.put('g', "eight");
        Map<Character, String> map2 = new HashMap<>();
        map2.put('h', "three");
        map2.put('f', "five");
        map2.put('s', "seven");
        Map<Character, String> map3 = new HashMap<>();
        map3.put('o', "one");
        map3.put('i', "nine");
        
        Map<Character, Integer> numMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            Integer num = numMap.get(c);
            if (num == null) {
                numMap.put(c, 1);
            } else {
                numMap.put(c, num + 1);
            }
        }
        List<String> list = new ArrayList<>();
        filterNumMap(numMap, map, digitMap, list);
        filterNumMap(numMap, map2, digitMap, list);
        filterNumMap(numMap, map3, digitMap, list);
        
        StringBuilder builder = new StringBuilder();
        list.stream().sorted().forEach(s1 -> builder.append(s1));
        return builder.toString();
    }
    
    private void filterNumMap(Map<Character, Integer> numMap, Map<Character, String> map, Map<String, String> digitMap, List<String> list) {
        for (Map.Entry<Character, Integer> entry : numMap.entrySet()) {
            char ch = entry.getKey();
            int num = entry.getValue();
            String value = map.get(ch);
            if (value != null) {
                for (int i = 0; i < num; i++) {
                    list.add(digitMap.get(value));
                    for (char c : value.toCharArray()) {
                        int n = numMap.get(c) - 1;
                        numMap.put(c, n);
                    }
                }
            }
        }
    }
    
    /**
     * 找规律解法
     * accept my knee
     */
    public String originalDigits2(String s) {
        int[] count = new int[10];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'z') count[0]++;
            if (c == 'w') count[2]++;
            if (c == 'x') count[6]++;
            if (c == 's') count[7]++; //7-6
            if (c == 'g') count[8]++;
            if (c == 'u') count[4]++;
            if (c == 'f') count[5]++; //5-4
            if (c == 'h') count[3]++; //3-8
            if (c == 'i') count[9]++; //9-8-5-6
            if (c == 'o') count[1]++; //1-0-2-4
        }
        count[7] -= count[6];
        count[5] -= count[4];
        count[3] -= count[8];
        count[9] = count[9] - count[8] - count[5] - count[6];
        count[1] = count[1] - count[0] - count[2] - count[4];
        StringBuilder sb = new StringBuilder();
        //数组,连排序都省了
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j < count[i]; j++) {
                sb.append(i);
            }
        }
        return sb.toString();
    }
    
    /**
     * 462. Minimum Moves to Equal Array Elements II
     * 操作步骤使数组中数字全等,每步操作+1 or -1 选定的元素
     * <p>
     * 排序后,头尾数字只差和
     *
     * @param nums int[] 数组长度最长10000
     * @return int
     */
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        int count = 0;
        while (i < j) {
            count += nums[j] - nums[i];
            i++;
            j--;
        }
        return count;
    }
    
    /**
     * 找出最后基准数字,操作步数=每个数字与基准数差之和
     */
    public int minMoves22(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        int mid = nums[len / 2];
        int move = 0;
        for (int n : nums) {
            move += Math.abs(n - mid);
        }
        return move;
    }
    
    /**
     * 513. Find Bottom Left Tree Value
     * 找出最底行的最左数字
     *
     * @param root TreeNode
     * @return int
     */
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Integer result;
        while (true) {
            Integer left = null;
            Queue<TreeNode> tmpQ = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.remove();
                if (left == null) {
                    left = node.val;
                }
                if (node.left != null) {
                    tmpQ.add(node.left);
                }
                if (node.right != null) {
                    tmpQ.add(node.right);
                }
            }
            if (tmpQ.isEmpty()) {
                result = left;
                break;
            }
            queue = tmpQ;
        }
        return result == null ? 0 : result;
    }
    
    /**
     * 498. Diagonal Traverse
     * 对角线遍历
     *
     * @param matrix int[][]
     * @return int[]
     */
    public int[] findDiagonalOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return new int[0];
        int n = matrix[0].length;
        int len = m * n;
        int[] res = new int[len];
        int i = 0;
        int j = 0;
        boolean order = true;
        int index = 0;
        while (index < len) {
            if (order) {
                //向上
                if (j < 0) {
                    j++;
                    if (i > m - 1) {
                        i--;
                        j++;
                    }
                }
                if (i >= m) {
                    i--;
                    j += 2;
                }
                if (j >= n) {
                    j--;
                }
                while (i >= 0 && j < n && index < len) {
                    res[index] = matrix[i][j];
                    i--;
                    j++;
                    index++;
                }
            } else {
                //向下
                if (i < 0) {
                    i++;
                    if (j > n - 1) {
                        i++;
                        j--;
                    }
                }
                if (j >= n) {
                    j--;
                    i += 2;
                }
                if (i >= m) {
                    i--;
                }
                while (i < m && j >= 0 && index < len) {
                    res[index] = matrix[i][j];
                    i++;
                    j--;
                    index++;
                }
            }
            order = !order;
        }
        return res;
    }
    
    /**
     * 515. Find Largest Value in Each Tree Row
     * <p>
     * 找出二叉树每一行的最大值
     * 按层打印二叉树,找出每层的最大值
     *
     * @param root TreeNode
     * @return list
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (true) {
            int max = Integer.MIN_VALUE;
            Queue<TreeNode> tmpQ = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.remove();
                max = Math.max(node.val, max);
                if (node.left != null) {
                    tmpQ.add(node.left);
                }
                if (node.right != null) {
                    tmpQ.add(node.right);
                }
            }
            result.add(max);
            if (tmpQ.isEmpty()) {
                break;
            }
            queue = tmpQ;
        }
        return result;
    }
    
    
    /**
     * 201. Bitwise AND of Numbers Range
     * m到n之间的全部数字按位与
     * input : 5, 7
     * output: 4
     * 纯数学计算
     * find the common prefix of m and n 's binary code.
     *
     * @param m int 0 <= m <= n <= 2147483647
     * @param n int
     * @return int
     */
    public int rangeBitwiseAnd(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        int moveFactor = 1;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            moveFactor <<= 1;
        }
        return m * moveFactor;
    }
    
    /**
     * By using Brian Kernighan's Algorithm
     */
    public int rangeBitwiseAnd2(int m, int n) {
        while (n > m) {
            n &= (n - 1);
        }
//        return n; 两种返回都正确
        return m & n;
    }
    
    /**
     * 491. Increasing Subsequences
     * 找出数组中全部递增子序列,子序列最小长度为2
     * 数组中范围  [-100,100]
     *
     * @param nums int[] The length of the given array will not exceed 15.
     * @return list list integer
     */
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> holder = new ArrayList<>();
        findSequence(res, holder, 0, nums);
        return new ArrayList<>(res);
    }
    
    private void findSequence(Set<List<Integer>> res, List<Integer> holder, int index, int[] nums) {
        if (holder.size() >= 2) {
            res.add(new ArrayList<>(holder));
        }
        for (int i = index; i < nums.length; i++) {
            if (holder.size() == 0 || holder.get(holder.size() - 1) <= nums[i]) {
                holder.add(nums[i]);
                findSequence(res, holder, i + 1, nums);
                holder.remove(holder.size() - 1);
            }
        }
    }
    
    /**
     * 187. Repeated DNA Sequences
     * 所有的DNA序列都是由 A, C, G, and T 组成
     * 找出重复出现的10-letter-long sequences子字符串
     *
     * @param s String
     * @return List string
     */
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> result = new HashSet<>();
        if (s == null || s.length() <= 10) return new ArrayList<>();
        int len = s.length();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < len - 9; i++) {
            String sub = s.substring(i, i + 10);
            if (set.contains(sub)) {
                result.add(sub);
            } else {
                set.add(sub);
            }
        }
        return new ArrayList<>(result);
    }
    
    /**
     * 477. Total Hamming Distance
     * 求数组中全部数字的汉明距离之和
     * Length of the array will not exceed 10^4.
     * 纯数学角度解
     * Integer 32 bit,纵向
     *
     * @param nums int[]
     * @return int
     */
    public int totalHammingDistance(int[] nums) {
        int total = 0;
        int len = nums.length;
        for (int j = 0; j < 32; j++) {
            int bitCount = 0;
            for (int num : nums) {
                bitCount += (num >> j) & 1;
            }
            total += bitCount * (len - bitCount); //1的个数*0的个数 = total上贡献的汉明距离
        }
        return total;
    }
    
    
    /**
     * 445. Add Two Numbers II
     * 两个链表非负整数
     * 每个节点是单位数字,高位在前面,从链表尾部开始相加进位
     * 不能改变输入链表的顺序
     *
     * @param l1 ListNode
     * @param l2 ListNode
     * @return ListNode
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        ListNode head = l1;
        while (head != null) {
            s1.add(head);
            head = head.next;
        }
        head = l2;
        while (head != null) {
            s2.add(head);
            head = head.next;
        }
        Stack<ListNode> ss = new Stack<>();
        int carry = 0;
        while (!s1.isEmpty() && !s2.isEmpty()) {
            ListNode n1 = s1.pop();
            ListNode n2 = s2.pop();
            int tmp = n1.val + n2.val + carry;
            int sum = tmp % 10;
            carry = tmp / 10;
            ss.push(new ListNode(sum));
        }
        carry = addRemainNode(s1, carry, ss);
        carry = addRemainNode(s2, carry, ss);
        
        if (carry > 0) {
            ss.push(new ListNode(carry));
        }
        
        head = ss.pop();
        ListNode cur = head;
        while (!ss.isEmpty()) {
            cur.next = ss.pop();
            cur = cur.next;
        }
        return head;
    }
    
    private int addRemainNode(Stack<ListNode> s, int carry, Stack<ListNode> ss) {
        while (!s.isEmpty()) {
            ListNode n = s.pop();
            int tmp = n.val + carry;
            int sum = tmp % 10;
            carry = tmp / 10;
            ss.push(new ListNode(sum));
        }
        return carry;
    }
    
    
    /**
     * 56. Merge Intervals
     * merge all overlapping(重叠的) intervals.
     * input: [1,3],[2,6],[8,10],[15,18],
     * output: [1,6],[8,10],[15,18].
     * 两两合并
     *
     * @param intervals List
     * @return List
     */
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null) return null;
        if (intervals.size() <= 1) return intervals;
        
        Collections.sort(intervals, (o1, o2) -> o1.start - o2.start == 0 ?
                o1.end - o2.end : o1.start - o2.start);
        List<Interval> result = new ArrayList<>();
        int i = 0;
        int size = intervals.size();
        while (i < size) {
            Interval i1 = intervals.get(i);
            int j = i + 1;
            boolean tag = false;
            Interval i11 = i1; //遍历的end最大值
            while (j < size) {
                Interval i2 = intervals.get(j);
                if (i11.end >= i2.start) {
                    j++;
                    i11 = i11.end < i2.end ? i2 : i11;
                } else {
                    tag = true;
                    break;
                }
            }
            if (j == i + 1) {
                result.add(new Interval(i1.start, i1.end));
            } else {
                Interval tmp = tag || j == size ? intervals.get(j - 1) : intervals.get(j);
                result.add(new Interval(i1.start, Math.max(Math.max(i1.end, i11.end), tmp.end)));
            }
            i = j;
            
        }
        return result;
    }
    
    private static class Interval {
        int start;
        int end;
        
        Interval() {
            start = 0;
            end = 0;
        }
        
        Interval(int s, int e) {
            start = s;
            end = e;
        }
        
        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
    
    /**
     * 495. Teemo Attacking
     * 求中毒的总时间
     *
     * @param timeSeries int[] 升序的时间序列
     * @param duration   int 中毒持续时间
     * @return int
     */
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) return 0;
        int total = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            int diff = timeSeries[i + 1] - timeSeries[i];
            total += diff < duration ? diff : duration;
        }
        return total + duration;
    }
    
    /**
     * 109. Convert Sorted List to Binary Search Tree
     * 升序排列的链表 转换成 平衡二叉搜索树
     *
     * @param head ListNode
     * @return TreeNode
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        int size = 0;
        ListNode runner = head;
        node = head;
        while (runner != null) {
            runner = runner.next;
            size++;
        }
        return inorderHelper(0, size - 1);
    }
    
    private ListNode node;
    
    private TreeNode inorderHelper(int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        
        TreeNode left = inorderHelper(start, mid - 1);
        TreeNode treeNode = new TreeNode(node.val);
        treeNode.left = left;
        node = node.next;
        
        TreeNode right = inorderHelper(mid + 1, end);
        treeNode.right = right;
        
        return treeNode;
    }
    
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int x) {
            val = x;
        }
        
        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }
    
    private static class ListNode {
        int val;
        ListNode next;
        
        ListNode(int x) {
            val = x;
        }
        
        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }
    
    /**
     * 494. Target Sum
     * 数组中每个数字有 + - 符号,找出所有可能使和等于S
     * 找出subSet P和N
     * sum(P) - sum(N) = S
     * sum(P) - sum(N) + sum(p) + sum(N) = S + sum(p) + sum(N)
     * 2 * sum(P) = S + sum(nums)
     * sum(P) = (S + sum(nums)) / 2
     *
     * @param nums int[] 非负整数
     * @param S    int target sum
     * @return int
     */
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        return sum < S || ((sum + S) & 1) == 1 ? 0 : subsetSum(nums, (sum + S) >>> 1);
    }
    
    /**
     * 返回子数组和等于s的个数
     */
    private int subsetSum(int[] nums, int s) {
        int[] dp = new int[s + 1];
        dp[0] = 1;
        for (int n : nums) {
            for (int i = s; i >= n; i--) {
                dp[i] += dp[i - n];
            }
        }
        return dp[s];
    }
    
    /**
     * 406. Queue Reconstruction by Height
     * 重新排队 数组中(h,k) h人的高度,k是在此人之前大于等于该身高的人数
     * Input: [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
     * Output: [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
     * 最高的人先排序,然后次高的人insert sort,以此类推
     * brilliant solution 先排序height,再根据k insert即可
     *
     * @param people int[][]
     * @return int[][]
     */
    public int[][] reconstructQueue(int[][] people) {
        if (people == null) return null;
        Arrays.sort(people, (o1, o2) -> o1[0] != o2[0] ? o2[0] - o1[0] : o1[1] - o2[1]);
        List<int[]> res = new ArrayList<>();
        for (int[] p : people) {
            res.add(p[1], p);
        }
        return res.toArray(new int[people.length][]);
    }
    
    /**
     * 413. Arithmetic Slices
     * arithmetic 等差数列 至少包含三个元素
     * 找出数组A中 arithmetic 的个数
     * A = [1, 2, 3, 4]
     * return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
     *
     * @param A int[]
     * @return int
     */
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3) return 0;
        int res = 0;
        for (int i = 0; i < A.length - 2; i++) {
            int diff = A[i + 1] - A[i];
            if ((A[i + 2] - A[i + 1]) == diff) {
                res++;
                int j = i + 3;
                while (j < A.length) {
                    //普通解法
                    if ((A[j] - A[j - 1]) == diff) {
                        res++;
                        j++;
                    } else {
                        break;
                    }
                }
            }
        }
        return res;
    }
    
    //discuss 解法
    public int numberOfArithmeticSlices2(int[] A) {
        int cur = 0, sum = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                cur += 1;
                sum += cur; //trick
            } else {
                cur = 0;
            }
        }
        return sum;
    }
    
    /**
     * 419. Battleships in a Board
     * 二维数组由 . 和 X 组成,找出其中 1*N 或者 N*1 组成的battleship,不能有交叉
     * <p>
     * X..X
     * ...X
     * ...X return 2
     * <p>
     * ...X
     * XXXX
     * ...X invalid
     *
     * @param board char[][]
     * @return int
     */
    public int countBattleships(char[][] board) {
        int m = board.length;
        if (m == 0) return 0;
        int n = board[0].length;
        
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') continue;
                if (i > 0 && board[i - 1][j] == 'X') continue;
                if (j > 0 && board[i][j - 1] == 'X') continue;
                count++;
            }
        }
        return count;
    }
    
    public int countBattleships2(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X' && (i == 0 || board[i - 1][j] == '.')
                        && (j == 0 || board[i][j - 1] == '.')) {
                    count++;
                }
            }
        }
        return count;
    }
    
    /**
     * 503. Next Greater Element II
     * 找出下一个比当前元素大的元素,不存在输出-1
     * [1,2,1] -> [2, -1, 2]
     *
     * @param nums int[] 环形数组,有重复 The length of given array won't exceed 10000.
     * @return int[]
     */
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] arr = new int[len * 2];
        System.arraycopy(nums, 0, arr, 0, len);
        System.arraycopy(nums, 0, arr, len, len);
        
        Map<Element, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int n = nums[i];
            int next = n;
            for (int j = i + 1; j < (i + len); j++) {
                if (arr[j] > next) {
                    next = arr[j];
                    break;
                }
            }
            map.put(new Element(i, n), next > n ? next : -1);
        }
        
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = map.get(new Element(i, nums[i]));
        }
        return res;
    }
    
    private static class Element {
        private int index;
        private int value;
        
        public Element(int index, int value) {
            this.index = index;
            this.value = value;
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            
            Element element = (Element) o;
            
            if (index != element.index) return false;
            return value == element.value;
            
        }
        
        @Override
        public int hashCode() {
            int result = index;
            result = 31 * result + value;
            return result;
        }
    }
    
    /**
     * 442. Find All Duplicates in an Array
     * <p>
     * 1 ≤ a[i] ≤ n (n = size of array),
     * 有些数字出现两次,有些出现一次
     * <p>
     * without extra space and in O(n) runtime
     *
     * @param nums int[]
     * @return List<integer>
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int[] arr = new int[nums.length];
        for (int n : nums) {
            if (arr[n - 1] == 0) {
                arr[n - 1] = n;
            } else {
                result.add(n);
            }
        }
        return result;
    }
    
}
