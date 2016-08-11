package com.ryl.learn.lecode;

import java.util.*;

/**
 * Created on 16/5/12 下午4:04.
 */
public class MediumCode {

    public static void main(String[] args) {
        MediumCode code = new MediumCode();
//        System.out.println(code.canJump(new int[]{2, 3, 1, 1, 4}));
//        System.out.println(code.canJump(new int[]{3, 2, 1, 0, 4}));

        int[][] matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        matrix = new int[][]{{1}};
        System.out.println(code.searchMatrix(matrix, 2));
//        for(int i = 1 ;i < 20;i++) {
//            System.out.println(i +" "+code.mySqrt(i));
//        }
//        System.out.println(code.mySqrt(2147483647));
        ListNode head = new ListNode(1);
        ListNode tmp = head;
        for (int i = 2; i <= 2; i++) {
            tmp.next = new ListNode(i);
            tmp = tmp.next;
        }
        code.printListNode(head);
        head = code.rotateRight(head, 3);
        code.printListNode(head);

        System.out.println(code.findDuplicate(new int[]{1, 1, 2}));
        System.out.println(code.canMeasureWater(2, 6, 5));
        char[][] cmatrix = new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '1', '1', '1'}};
        System.out.println(code.maximalSquareO1(cmatrix));

//        System.out.println("1/3=" + code.fractionToDecimal(1, 3));
//        System.out.println("1/5=" + code.fractionToDecimal(1, 5));
//        System.out.println("1/99=" + code.fractionToDecimal(1, 99));
//        System.out.println("1/17=" + code.fractionToDecimal(1, 17));
//        System.out.println("1/6=" + code.fractionToDecimal(1, 6));
//        System.out.println("1/90=" + code.fractionToDecimal(1, 90));
//        System.out.println("22/7=" + code.fractionToDecimal(22, 7));
//        System.out.println("-50/8=" + code.fractionToDecimal(-50, 8));
//        System.out.println("7/-12=" + code.fractionToDecimal(7, -12));
//        System.out.println("1/214748364=" + code.fractionToDecimal(1, 214748364));
        System.out.println(Integer.MIN_VALUE + " " + Integer.MAX_VALUE);
        System.out.println("-1/-2147483648=" + code.fractionToDecimal(-1, -2147483648));

    }

    /**
     * 221. Maximal Square
     * Given a 2D binary matrix filled with 0's and 1's,
     * find the largest square containing only 1's and return its area.
     * 找到最大面积的正方形 DP
     *
     * @param matrix char[][]
     * @return maxSquare int
     */
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int max = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n + 1][m + 1];
        // dp(i, j) represents the length of the square
        // whose lower-right corner is located at (i, j)
        // dp(i, j) = min{ dp(i-1, j-1), dp(i-1, j), dp(i, j-1) }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }

    // u r so creative nice solution
    //use O(1) space
    public int maximalSquareO1(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int max = '0';
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] != '0' && i != 0 && j != 0) {
                    matrix[i][j] = (char) (Math.min(
                            Math.min(matrix[i - 1][j] - '0', matrix[i][j - 1] - '0'),
                            matrix[i - 1][j - 1] - '0'
                    ) + 1 + '0');
                }
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }
        return (max - '0') * (max - '0');
    }

    /**
     * 148. Sort List
     * Sort a linked list in O(nlogn) time using constant space complexity.
     * Merge Sort 归并排序
     *
     * @param head ListNode
     * @return ListNode
     */
    public ListNode sortList(ListNode head) {
        // TODO: 16/7/25  
        return null;
    }

    /**
     * 365. Water and Jug Problem
     * 使用容量为x y的壶,是否能准确量出z容量的水,水量无限
     * z必须可以除尽x和y的最大公约数
     *
     * @param x int
     * @param y int
     * @param z int
     * @return boolean
     */
    public boolean canMeasureWater(int x, int y, int z) {
        int total = x + y;
        if (total < z) return false;
        return z == 0 || z % gcd(x, y) == 0;
    }

    //辗转相除法求最大公约数
    private int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }

    /**
     * 287. Find the Duplicate Number
     * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
     * prove that at least one duplicate number must exist.
     * Assume that there is only one duplicate number, find the duplicate one.
     * 找出重复的数字,重复数字出现大于1次,可能是多次
     * 1,先排序,然后找出一个重复的数字 该题的用意明显不是这样
     * 2,使用二分查找先确定一个中间值mid，然后统计整个数组，看比mid小的数是否比mid多，如果多的话，说明重复的值就在[left, mid-1]之间，
     * 否则就在[mid+1, right]之间。
     *
     * @param nums int[]
     * @return int
     */
    public int findDuplicate(int[] nums) {
        if (nums == null) return 0;
        if (nums.length <= 2) return nums[0];
        int left = 1;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cnt = 0;
            for (int val : nums) {
                if (val <= mid) {
                    cnt++;
                }
            }
            if (cnt <= mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    /**
     * 46. Permutations
     * Given a collection of [distinct] numbers, return all possible permutations.
     * 参考com.ryl.learn.puzzlers.Permutation
     *
     * @param nums int[]
     * @return 数字的全排列
     */
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null) return null;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums.length == 1) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(nums[0]);
            res.add(list);
            return res;
        } else {
            for (int i = 0; i < nums.length; i++) {
                Integer num = nums[i];
                List<Integer> result = new ArrayList<Integer>();
                List<Integer> resultA = new ArrayList<Integer>();
                resultA.addAll(result);
                resultA.add(num);
                int[] arr = new int[nums.length - 1];
                System.arraycopy(nums, 0, arr, 0, i);
                System.arraycopy(nums, i + 1, arr, i, nums.length - i - 1);
                for (List<Integer> tmp : permute(arr)) {
                    result = new ArrayList<Integer>(); //关键点
                    result.addAll(resultA);
                    result.addAll(tmp);
                    res.add(result);
                }
            }
            return res;
        }
    }

    /**
     * 357. Count Numbers with Unique Digits
     * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n(10的n次方).
     * Given n = 2, return 91 (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])
     * <p>
     * Let f(k) = count of numbers with unique digits with length equals k.
     * f(1) = 10, ..., f(k) = 9 * 9 * 8 * ... (9 - k + 2) [The first factor is 9 because a number cannot start with 0].
     * k位数,第一位有1-9种选择,第二位0-9(除去第一位数字选择)9中选择
     *
     * @param n int
     * @return int
     */
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res += calculateK(i);
        }
        return res;
    }

    private int calculateK(int k) {
        if (k == 0) return 1;
        if (k == 1) return 10;
        int res = 9 * 9;
        for (int i = 2; i < k; i++) {
            int n = 9 - (i + 1) + 2;
            if (n < 1) n = 1;
            res *= n;
        }
        return res;
    }

    /**
     * 179. Largest Number
     * Given a list of non negative integers, arrange them such that they form the largest number.
     * given [3, 30, 34, 5, 9], the largest formed number is 9534330.
     * 数组从大到小排序,排序规则按位比较
     *
     * @param nums int[]
     * @return String largestNumber
     */
    public String largestNumber(int[] nums) {
        if (nums == null) return null;
        if (nums.length == 1) return String.valueOf(nums[0]);
        for (int i = 0; i < nums.length - 1; i++) {
            int max = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (compareNum(nums[j], nums[max]) > 0) {
                    max = j;
                }
            }
            if (i != max) {
                int tmp = nums[i];
                nums[i] = nums[max];
                nums[max] = tmp;
            }
        }
        String res = "";
        for (int i = 0; i < nums.length; i++) {
            if ("".equals(res) && nums[i] == 0) {
                continue;
            }
            res += nums[i];
        }
        return "".equals(res) ? "0" : res;
    }

    //交换顺序,比较两个数字大小,确定排序关系
    private int compareNum(int num1, int num2) {
        String str1 = "" + num1 + num2;
        String str2 = "" + num2 + num1;
        for (int i = 0; i < str1.length(); i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(i);
            if (ch1 == ch2) {
                continue;
            }
            return ch1 - ch2 > 0 ? 1 : -1;
        }
        return 0;
    }


    /**
     * 151. Reverse Words in a String
     * Given an input string, reverse the string word by word.
     * s = "the sky is blue",
     * return "blue is sky the".
     * 思路比较清晰,先翻转整个字符串,再根据空格翻转每个单词,边界条件比较多
     * 前后空格消除,中间空格合并问题
     *
     * @param s String
     * @return String
     */
    public String reverseWords(String s) {
        if (s == null || s.equals("")) return s;
        int len = s.length();
        int i = len - 1;
        char[] arr = new char[len];

        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        int index = 0;
        while (i >= 0) {
            char cur = s.charAt(i);
            char bef = arr[index > 0 ? index - 1 : index];
            if (cur == ' ' && bef == ' ') {
                i--;
                continue;
            }
            arr[index] = cur;
            index++;
            i--;
        }
        len = index;
        i = 0;
        int j = i;
        while (j < len) {
            if (i < j && arr[j] == ' ') {
                swapCharArray(arr, i, j - 1);
                j++;
                i = j;
            }

            while (j < len && arr[j] == ' ') {
                j++;
                i = j;
            }

            if (j < len && arr[j] != ' ') {
                j++;
            }
        }
        swapCharArray(arr, i, j - 1);
        int newlen = len > 0 && arr[len - 1] == ' ' ? len - 1 : len;
        char[] newarr = new char[newlen];
        System.arraycopy(arr, 0, newarr, 0, newlen);
        return new String(newarr);
    }

    private void swapCharArray(char[] arr, int i, int j) {
        while (i < j) {
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
    }

    /**
     * 61. Rotate List
     * Given a list, rotate the list to the right by k places, where k is non-negative.
     * 1->2->3->4->5->NULL and k = 2,
     * 4->5->1->2->3->NULL.
     * 右旋转链表
     *
     * @param head ListNode
     * @param k    int
     * @return new head ListNode
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0)
            return head;
        ListNode node = head;
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        k = k % len;
        if (k == 0) {
            return head;
        }
        ListNode node1 = head;
        ListNode node2 = head;
        int i = 1;
        while (node2 != null && i < k) {
            node2 = node2.next;
            i++;
        }
        ListNode pre = null;
        while (node2 != null && node2.next != null) {
            pre = node1;
            node1 = node1.next;
            node2 = node2.next;
        }
        if (pre != null) {
            pre.next = null;
            node2.next = head;
        }
        return node1;
    }

    /**
     * 143. Reorder List
     * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
     * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
     * You must do this in-place without altering the nodes' values.
     * 使用stack bug-free
     *
     * @param head ListNode
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Stack<ListNode> stack = new Stack<ListNode>();
        while (slow != null) {
            stack.push(slow);
            slow = slow.next;
        }
        ListNode node = head;
        ListNode next = node.next;
        while (!stack.isEmpty()) {
            ListNode tmp = stack.pop();
            node.next = tmp;
            tmp.next = next;
            node = next;
            next = next.next;
        }
        next.next = null;
    }


    /**
     * 367. Valid Perfect Square
     * Given a positive integer num, write a function which returns True if num is a perfect square else False.
     * Note: Do not use any built-in library function such as sqrt.
     * 判断一个数是否能被完全开方
     * 16 true | 14 false
     *
     * @param num int
     * @return true/false
     */
    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        int begin = 2;
        int end = num / 2;
        while (begin <= end) {
            int mid = (end - begin) / 2 + begin;
            if (num % mid == 0 && num / mid == mid)
                return true;
            if (num / mid > mid) {
                begin = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

    /**
     * 69. Sqrt(x)
     * Compute and return the square root of x.
     * 求开方
     * return new Double(Math.sqrt(x)).intValue();
     * 使用jdk Math函数不是该题本意,但是AC
     *
     * @param x int
     * @return int
     */
    public int mySqrt(int x) {
//        return new Double(Math.sqrt(x)).intValue();
        if (x < 0) return -1;
        if (x <= 1) return x;
        int begin = 1;
        int end = x / 2;
        int mid = (end - begin) / 2 + begin;
        while (begin <= end) {
            mid = (end - begin) / 2 + begin;
            int div = x / mid;
            if (div < mid) {
                end = mid - 1;
            } else if (div > mid) {
                begin = mid + 1;
            } else {
                return mid;
            }
        }
        if (mid > x / mid) return mid - 1;
        return mid;
    }

    /**
     * 50. Pow(x, n)
     * <p>
     * 1 如果y为偶数，直接计算mypow(x, y/2) * mypow(x, y/2)；
     * 2 如果y为奇数，则y-1为偶数，回到了第一种情况。
     *
     * @param x double
     * @param n int
     * @return double
     */
    public double myPow(double x, int n) {
//        return Math.pow(x, n); //直接用jdk函数当然不是这题的本意
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n < 0) return 1 / dopow(x, n);
        else return dopow(x, n);
    }

    private double dopow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        double result;
        double tmp = dopow(x, n / 2);
        if ((n & 1) != 0) {
            result = x * tmp * tmp;
        } else {
            result = tmp * tmp;
        }
        return result;
    }

    /**
     * 372. Super Pow
     * calculate a^b mod 1337
     * a is a positive integer and b is an extremely large positive integer given in the form of an array.
     * <p>
     * a^b % 1337 = (a%1337)^b % 1337
     * xy % 1337 = ((x%1337) * (y%1337)) % 1337 其中xy是一个数字,45 98等
     *
     * @param a int
     * @param b int[]
     * @return int
     */
    public int superPow(int a, int[] b) {
        if (b == null || b.length == 0) return 1;
        a = a % 1337;
        int len = b.length;
        int lastBit = b[len - 1];
        int[] b2 = new int[len - 1];
        System.arraycopy(b, 0, b2, 0, len - 1);
        return (superPow(superPow(a, b2), 10)) * superPow(a, lastBit) % 1337;
    }

    private int superPow(int a, int k) {
        if (k == 0) return 1;
        int ans = 1;
        for (int i = 1; i <= k; i++) {
            ans = (ans * a) % 1337;
        }
        return ans;
    }

    /**
     * 240. Search a 2D Matrix II
     * Write an efficient algorithm that searches for a value in an m x n matrix.
     * (1) Integers in each row are sorted in ascending from left to right. 每一行递增
     * (2) Integers in each column are sorted in ascending from top to bottom. 每一列递增
     * 剑指offer 从右上角开始查找,缩小范围
     * <p>
     * [
     * [1,   4,  7, 11, 15],
     * [2,   5,  8, 12, 19],
     * [3,   6,  9, 16, 22],
     * [10, 13, 14, 17, 24],
     * [18, 21, 23, 26, 30]
     * ]
     *
     * @param matrix int[][]
     * @param target int
     * @return true/false
     */
    public boolean searchMatrixII(int[][] matrix, int target) {
        if (matrix == null) {
            return false;
        }
        int m = 0;
        int n = matrix[0].length - 1;
        while (m <= matrix.length - 1 && n >= 0) {
            if (matrix[m][n] == target) {
                return true;
            } else if (matrix[m][n] > target) {
                n--;
            } else {
                m++;
            }
        }
        return false;
    }

    /**
     * 74. Search a 2D Matrix
     * Write an efficient algorithm that searches for a value in an m x n matrix.
     * (1) Integers in each row are sorted from left to right.
     * (2) The first integer of each row is greater than the last integer of the previous row.
     * 每行首元素都比上一行的最后一个元素要大
     * 按照II剑指offer方法,从右上角开始查找也AC
     * 应该有另外的方法 [二分查找]
     * <p>
     * [
     * [1,   3,  5,  7],
     * [10, 11, 16, 20],
     * [23, 30, 34, 50]
     * ]
     *
     * @param matrix int[][]
     * @param target int
     * @return true/false
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) return false;
        int i = 0;
        int j = matrix.length * matrix[0].length;
        while (i <= j) {
            int mid = (j - i) / 2 + i; //(i+j)/2 会int溢出
            int m = mid / matrix[0].length;
            int n = mid % matrix[0].length;
            if (m > matrix.length - 1 || n > matrix[0].length - 1)
                break;
            if (matrix[m][n] == target) {
                return true;
            } else if (matrix[m][n] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return false;
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
     * 1,除法的正确性
     * 2,超长的循环小数,循环开始位置的判断,使用Map<Integer,List<Integer>>
     * 3,结构正负判断
     * 4,int整数越界,改成long
     * 2016-08-11写了一天终于ac,不容易
     * @param numerator1   int 除数
     * @param denominator1 int 被除数
     * @return string 小数表示
     */
    public String fractionToDecimal(int numerator1, int denominator1) {
        if (denominator1 == 0) return null;
        if (numerator1 == 0) return "0";
        //-2147483648 2147483647 越界
        long numerator = (long) numerator1;
        long denominator = (long) denominator1;

        long intPart = numerator / denominator;
        long remainder = numerator % denominator;
        if (remainder == 0) {
            return String.valueOf(intPart);
        }
        String flag = "";
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
            flag = "-";
        }
        intPart = intPart < 0 ? -intPart : intPart;
        numerator = numerator < 0 ? -numerator : numerator;
        denominator = denominator < 0 ? -denominator : denominator;
        remainder = remainder < 0 ? -remainder : remainder;

        //结果和余数,不同的进位,可能产生相同的余数
        Map<Long, List<Long>> map = new HashMap<Long, List<Long>>();
        String decimalPart = "";
        long begin = 0;
        int index = 0;
        boolean isrec = false;
        while (true) {
            long divide = remainder * 10;
            long res = divide / denominator;
            decimalPart += res;
            if (res == 0) {
                remainder = divide;
                begin = res;
            } else {
                remainder = divide % denominator;
                if (remainder == 0) {
                    break;
                }
                if (remainder == numerator) {
                    isrec = true;
                    break;
                }
            }
            if (map.keySet().contains(res)) {
                List<Long> list = map.get(res);
                if (list.contains(remainder)) {
                    isrec = true;
                    begin = res;
                    index = list.indexOf(remainder);
                    //删除最后一位
                    decimalPart = decimalPart.substring(0, decimalPart.length() - 1);
                    break;
                }
            }
            updateDecimalMap(res, remainder, map);
        }
        if (!isrec) {
            return flag + intPart + "." + decimalPart;
        }
        int i = decimalPart.indexOf("" + begin, index);
        if (i == -1) i = 0;
        return flag + intPart + "." + decimalPart.substring(0, i) + "(" + decimalPart.substring(i) + ")";
    }

    private void updateDecimalMap(long res, long remainder, Map<Long, List<Long>> map) {
        List<Long> set = map.get(res);
        if (set == null) {
            set = new ArrayList<Long>();
            set.add(remainder);
            map.put(res, set);
        } else {
            set.add(remainder);
        }
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
     * 319. Bulb Switcher
     * 开关灯,最后剩几盏灯亮着
     * 思路：思路只有一个，就是能够开方的数的个数。这很buggy
     * http://blog.csdn.net/qq508618087/article/details/50517503
     *
     * @param n int
     * @return int
     */
    public int bulbSwitch(int n) {
        return new Double(Math.sqrt(n)).intValue();
    }

    /**
     * 77. Combinations
     * Given two integers n and k,
     *
     * @param n int 1 - n
     * @param k int k
     * @return return all possible combinations of k numbers out of 1 ... n.
     */
    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0) return null;
        int[] arr = new int[n];
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        for (int i = 1; i <= k; i++) {
            doCombine(arr, list, 0, i, 0, result);
        }

        return result;
    }

    private void doCombine(int[] arr, List<Integer> list, int curLen, int combLen, int pos, List<List<Integer>> result) {
        if (curLen == combLen) {
            System.out.println(list);
            result.add(list);
        } else {
//            list = new ArrayList<Integer>();
            for (int i = pos; i < arr.length; i++) {
                list.add(curLen, arr[i]);
                doCombine(arr, list, curLen + 1, combLen, i + 1, result);
            }
        }
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

    private void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
