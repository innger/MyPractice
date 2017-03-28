package com.ryl.learn.lecode;

import java.util.*;

/**
 * easy problem 002
 * Created by renyulong on 16/3/8.
 */
public class EasyCode {
    
    public static void main(String[] args) {
        EasyCode code = new EasyCode();
        System.out.println(code.computeArea(0, 0, 0, 0, -1, -1, 1, 1));
        SortedMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for (int i = 0; i < 10; i++) {
            map.put(i, i);
        }
        map.remove(0);
        System.out.println(map.keySet().iterator().next());
        
        int[] arr = new int[]{1, 2, 10, 4, 4, 6, 1, 7, 8, 2, 10, 102, 32, 1, 3, 43};
        System.out.println("input " + Arrays.toString(arr));
        int[] res = code.getMinArray(arr, 4);
        System.out.println("output " + Arrays.toString(res));
        int[] res1 = code.getMinArrayII(arr, 4);
        System.out.println("output " + Arrays.toString(res1));
        
        System.out.println(code.reverseString("aabbccdd"));
        ListNode head = initList(9);
        printList(head);
        boolean b = code.isPalindrome(head);
        System.out.println(b);
        int rec = code.computeArea(0, 0, 0, 0, -1, -1, 1, 1);
        System.out.println(rec);
        
        System.out.println(code.longestPalindrome("abccccdd"));
        System.out.println(code.longestPalindrome("Aa"));
        
        System.out.println(code.addStrings("99", "9"));
        
        System.out.println(code.checkPerfectNumber3(99999993));
        System.out.println(code.checkPerfectNumber3(32582657));
        System.out.println(code.checkPerfectNumber3(28));
    }
    
    /**
     * 507. Perfect Number
     * 完美数字是正整数,并且等于其全部正整数除数的和,不包含自身
     * Input: 28 Output: True
     * Explanation: 28 = 1 + 2 + 4 + 7 + 14
     *
     * @param num int
     * @return true/false
     */
    public boolean checkPerfectNumber(int num) {
        if (num <= 1) return false;
        int div = 1;
        int sum = div;
        div++;
        int limit = num;
        while (div < limit) {
            if (num % div == 0) {
                int res = num / div;
                sum += div;
                sum += res;
                limit = res;
            }
            div++;
        }
        return sum == num;
    }
    
    //https://en.wikipedia.org/wiki/List_of_perfect_numbers
    //hard code
    private boolean checkPerfectNumber2(int num) {
        return num == 6 || num == 28 || num == 496 || num == 8128 || num == 33550336;
    }
    
    private boolean checkPerfectNumber3(int num) {
        if (num == 1) return false;
        int sum = 0;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                sum += i;
                if (i != num / i) sum += num / i;
            }
        }
        sum++;
        return sum == num;
    }
    
    /**
     * 415. Add Strings
     * Given two non-negative numbers num1 and num2 represented as string
     * return the sum of num1 and num2.
     * 大正整数相加
     *
     * @param num1 string
     * @param num2 string
     * @return string
     */
    public String addStrings(String num1, String num2) {
        if (num1 == null || num1.length() == 0 || "0".equals(num1)) {
            return num2;
        }
        if (num2 == null || num2.length() == 0 || "0".equals(num2)) {
            return num1;
        }
        String result = "";
        char[] array1 = num1.toCharArray();
        char[] array2 = num2.toCharArray();
        int len1 = array1.length;
        int len2 = array2.length;
        int len = Math.min(len1, len2);
        int carry = 0, i;
        for (i = 0; i < len; i++) {
            int index1 = len1 - 1 - i;
            int index2 = len2 - 1 - i;
            if (index1 < 0 || index2 < 0) break;
            char ch1 = array1[index1];
            char ch2 = array2[index2];
            int sum = carry + (ch1 - '0') + (ch2 - '0');
            carry = sum / 10;
            sum = sum % 10;
            result = sum + result;
        }
        if (i == len1 && i == len2) {
            return carry == 0 ? result : carry + result;
        }
        int index;
        char[] remain;
        if (i >= len2) {
            index = len1 - 1 - i;
            remain = array1;
        } else {
            index = len2 - 1 - i;
            remain = array2;
        }
        for (i = index; i >= 0; i--) {
            char ch = remain[i];
            int sum = carry + (ch - '0');
            carry = sum / 10;
            sum = sum % 10;
            result = sum + result;
        }
        return carry == 0 ? result : carry + result;
    }
    
    /**
     * 409. Longest Palindrome
     * Given a string which consists of lowercase or uppercase letters,
     * find the length of the longest palindromes that can be built with those letters.
     * 由给出的字符串中字符组成的最长回文
     * abccccdd -> dccaccd -> 7
     *
     * @param s string
     * @return int
     */
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char ch : s.toCharArray()) {
            Integer i = map.get(ch);
            if (i == null) {
                i = 0;
            }
            map.put(ch, i + 1);
        }
        //奇数只能保留一个,偶数个数全算
        boolean odd = false;
        int result = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Integer num = entry.getValue();
            if ((num & 1) == 0) {
                //偶数
                result += num;
            } else {
                result += (num - 1);
                odd = true;
            }
        }
        return odd ? result + 1 : result;
    }
    
    /**
     * 371. Sum of Two Integers
     * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
     *
     * @param a int
     * @param b int
     * @return sum
     */
    public int getSum(int a, int b) {
        if (b == 0) return a;
        int sum = a ^ b;
        int carry = (a & b) << 1;
        return getSum(sum, carry);
    }
    
    public int getSum2(int a, int b) {
        if ((a & b) == 0) return a | b;
        return getSum2(a ^ b, (a & b) << 1);
    }
    
    /**
     * 24. Swap Nodes in Pairs
     * Given a linked list, swap every two adjacent nodes and return its head.
     *
     * @param head ListNode
     * @return ListNode
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newhead = head.next;
        ListNode node = head;
        ListNode next = head.next;
        while (node.next != null) {
            ListNode temp = next.next;
            next.next = node;
            if (temp != null && temp.next != null) {
                node.next = temp.next;
            } else {
                node.next = temp;
                break;
            }
            node = temp;
            next = node.next;
        }
        return newhead;
    }
    
    /**
     * 141. Linked List Cycle
     * Given a linked list, determine if it has a cycle in it.
     * 快慢指针
     *
     * @param head ListNode
     * @return true/false
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * 350. Intersection of Two Arrays II
     * Given two arrays, write a function to compute their intersection.
     * 使用map记录nums1元素出现的次数,再遍历nums2判断 重复的元素
     * bug-free
     *
     * @param nums1 int[]
     * @param nums2 int[]
     * @return int[]
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[]{};
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : nums1) {
            if (map.containsKey(n)) {
                int c = map.get(n);
                map.put(n, c + 1);
            } else {
                map.put(n, 1);
            }
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int n : nums2) {
            if (map.containsKey(n)) {
                int c = map.get(n);
                if (c == 1) {
                    map.remove(n);
                } else {
                    map.put(n, c - 1);
                }
                list.add(n);
            }
        }
        if (list.isEmpty()) {
            return new int[]{};
        } else {
            int[] arr = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                arr[i] = list.get(i);
            }
            return arr;
        }
    }
    
    /**
     * 234. Palindrome Linked List
     * 判断一个链表是不是回文
     * 前半段链表翻转,从中间外两头比较
     *
     * @param head listNode
     * @return true/false
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        if (head.next == null) {
            //单个元素
            return true;
        }
        if (head.next.next == null) {
            //两个元素
            return head.val == head.next.val;
        }
        int len = 0;
        ListNode node = head;
        while (node != null) {
            len++;
            node = node.next;
        }
        if ((len & 1) == 0) {
            //偶数
            int mid = len / 2;
            int i = 0;
            ListNode n1 = head;
            ListNode n2 = head.next;
            n1.next = null;
            while (i < mid - 1) {
                ListNode n = n2.next;
                n2.next = n1;
                n1 = n2;
                n2 = n;
                i++;
            }
            while (n1 != null && n2 != null) {
                if (n1.val != n2.val) {
                    return false;
                }
                n1 = n1.next;
                n2 = n2.next;
            }
            return true;
        } else {
            //奇数
            int mid = len / 2;
            int i = 0;
            ListNode n1 = head;
            ListNode n2 = head.next;
            n1.next = null;
            while (i < mid) {
                ListNode n = n2.next;
                n2.next = n1;
                n1 = n2;
                n2 = n;
                i++;
            }
            n1 = n1.next;
            while (n1 != null && n2 != null) {
                if (n1.val != n2.val) {
                    return false;
                }
                n1 = n1.next;
                n2 = n2.next;
            }
            return true;
        }
    }
    
    /**
     * 输出每个移动区间内最小值 [堆排序-最小堆]
     * 构建m大小的最小堆
     * 这么简单的问题,当时居然没想出来,确实太挫了
     * 反复构建最小堆,移除不是堆顶,则记录下来
     *
     * @param arr int[]
     * @param m   int
     * @return int[]
     */
    public int[] getMinArrayII(int[] arr, int m) {
        int len = arr.length;
        int[] heap = new int[len];
        int hlen = m;
        System.arraycopy(arr, 0, heap, 0, m);
        minHeapMake(heap, m);
        List<Integer> set = new ArrayList<Integer>();//已移除元素的集合
        int[] result = new int[len - m + 1];
        int resi = 0;
        int i = 0;
        int j = m - 1;
        while (j < len) {
            if (arr[i] != heap[0]) {
                set.add(arr[i]);
                while (arr[i] != heap[0] && set.contains(heap[0]) && !set.isEmpty()) {
                    System.out.println("remove element " + heap[0]);
                    set.remove((Object) heap[0]);
                    heap[0] = 0;
                    minHeapDeleteNumber(heap, hlen);
                    hlen--;
                }
            }
            result[resi] = heap[0];
            if (arr[i] == heap[0]) {
                heap[0] = 0;
                minHeapDeleteNumber(heap, hlen);
                hlen--;
            }
            resi++;
            i++;
            j++;
            if (j == len) break;
            //arr[j]加入堆
            minHeapAddNumber(heap, hlen, arr[j]);
            hlen++;
        }
        return result;
    }
    
    private void minHeapFixup(int[] arr, int i) {
        int j = (i - 1) / 2;
        int temp = arr[i];
        while (j >= 0 && i != 0) {
            if (arr[j] <= temp)
                break;
            arr[i] = arr[j];
            i = j;
            j = (i - 1) / 2;
        }
        arr[i] = temp;
    }
    
    private void minHeapAddNumber(int[] arr, int n, int num) {
        arr[n] = num;
        minHeapFixup(arr, n);
    }
    
    private void minHeapFixDown(int[] arr, int i, int n) {
        int j = 2 * i + 1;
        int temp = arr[i];
        while (j < n) {
            if ((j + 1) < n && arr[j + 1] < arr[j])
                j++;
            if (arr[j] >= temp)
                break;
            arr[i] = arr[j];
            i = j;
            j = 2 * i + 1;
        }
        arr[i] = temp;
    }
    
    private void minHeapDeleteNumber(int[] arr, int n) {
        int temp = arr[0];
        arr[0] = arr[n - 1];
        arr[n - 1] = temp;
        minHeapFixDown(arr, 0, n - 1);
    }
    
    void minHeapMake(int[] arr, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            minHeapFixDown(arr, i, n);
        }
    }
    
    /**
     * m区间长度,窗口沿着数组移动,输出每次窗口中最小值组成的数组
     *
     * @param arr int[]
     * @param m   区间长度
     * @return int[] 最小值组成的数组
     */
    public int[] getMinArray(int[] arr, int m) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }
        if (m >= arr.length) {
            //窗口不移动,及arr中的最小值
            int min = Integer.MAX_VALUE;
            for (int num : arr) {
                if (min > num) {
                    min = num;
                }
            }
            return new int[]{min};
        }
        int[] res = new int[arr.length - m + 1];
        int resi = 0;
        int i = 0;
        int j = m - 1;
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>(); //按照key排序
        while (j < arr.length) {
            if (i == 0) {
                for (int n = i; n <= j; n++) {
                    fillTreeMap(map, arr[n]);
                }
                res[resi] = map.firstKey();
            } else {
                removeTreeMap(map, arr[i - 1]);
                fillTreeMap(map, arr[j]);
                res[resi] = map.firstKey();
            }
            i++;
            j++;
            resi++;
        }
        return res;
    }
    
    private void fillTreeMap(Map<Integer, Integer> map, int n) {
        Integer count = map.get(n);
        if (count == null) {
            map.put(n, 1);
        } else {
            map.put(n, count + 1);
        }
    }
    
    private void removeTreeMap(Map<Integer, Integer> map, int n) {
        Integer count = map.get(n);
        if (count <= 1) {
            map.remove(n);
        } else {
            map.put(n, count - 1);
        }
    }
    
    /**
     * 两个stack记录元素值
     */
    class MinStack2 {
        
        private Stack<Integer> stack;
        private Stack<Integer> minStack;
        
        public MinStack2() {
            stack = new Stack<Integer>();
            minStack = new Stack<Integer>();
        }
        
        public void push(int x) {
            stack.push(x);
            if (minStack.isEmpty()) {
                minStack.push(x);
            } else {
                int top = minStack.peek();
                if (x <= top) {
                    minStack.push(x);
                }
            }
        }
        
        public void pop() {
            if (!stack.isEmpty()) {
                int top = stack.pop();
                if (top == minStack.peek()) {
                    minStack.pop();
                }
            }
        }
        
        public int top() {
            return stack.peek();
        }
        
        public int getMin() {
            return minStack.peek();
        }
        
    }
    
    /**
     * 155. Min Stack
     * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
     * 用TreeMap记录排序的key
     */
    class MinStack {
        
        private TreeMap<Integer, Integer> map;
        private Stack<Integer> stack;
        private Integer min;
        
        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new Stack<Integer>();
            map = new TreeMap<Integer, Integer>();
            min = Integer.MAX_VALUE;
        }
        
        public void push(int x) {
            if (map.containsKey(x)) {
                int num = map.get(x);
                map.put(x, num + 1);
            } else {
                map.put(x, 1);
            }
            stack.push(x);
            if (x < min) {
                min = x;
            }
        }
        
        public void pop() {
            if (!stack.empty()) {
                int top = stack.pop();
                int num = map.get(top);
                if (num <= 1) {
                    map.remove(top);
                } else {
                    map.put(top, num - 1);
                }
                if (map.isEmpty()) {
                    min = Integer.MAX_VALUE;
                } else {
                    min = map.firstKey();
                }
            }
        }
        
        public int top() {
            return stack.peek();
        }
        
        public int getMin() {
            return min;
        }
    }
    
    
    /**
     * 223. Rectangle Area
     * (A,B) (C,D) (E,F) (G,H) 四个点组成两个矩形,求覆盖的总面积
     *
     * @param A int
     * @param B int
     * @param C int
     * @param D int
     * @param E int
     * @param F int
     * @param G int
     * @param H int
     * @return area int
     */
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = Math.abs((C - A) * (D - B));
        int area2 = Math.abs((G - E) * (H - F));
        //判断两个矩形是否有重合
        //无重合
        int left1 = Math.min(A, C);
        int right1 = Math.max(A, C);
        int left2 = Math.min(E, G);
        int right2 = Math.max(E, G);
        if (right1 <= left2 || left1 >= right2) {
            return area1 + area2;
        }
        int top1 = Math.max(B, D);
        int bom1 = Math.min(B, D);
        int top2 = Math.max(F, H);
        int bom2 = Math.min(F, H);
        if (bom1 >= top2 || top1 <= bom2) {
            return area1 + area2;
        }
        //有重合,计算area3
        int left = Math.max(left1, left2);
        int right = Math.min(right1, right2);
        int top = Math.min(top1, top2);
        int bom = Math.max(bom1, bom2);
        //重合部分面积
        int area3 = 0;
        if (left < right && top > bom) {
            area3 = (right - left) * (top - bom);
        }
        return area1 + area2 - area3;
    }
    
    private boolean isBetween(int a, int b, int target) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        return target > min && target < max;
    }
    
    
    /**
     * 242. Valid Anagram 同字母异序词
     * write a function to determine if t is an anagram of s.
     * map equals
     *
     * @param s string
     * @param t string
     * @return true/false
     */
    public boolean isAnagram(String s, String t) {
        if (s == null) {
            return t == null;
        }
        if (s.length() == 0) {
            return t != null && t.length() == 0;
        }
        Map<Character, Integer> maps = new HashMap<Character, Integer>();
        Map<Character, Integer> mapt = new HashMap<Character, Integer>();
        fillString2Map(s, maps);
        fillString2Map(t, mapt);
        return maps.equals(mapt);
    }
    
    private void fillString2Map(String s, Map<Character, Integer> map) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, 1 + map.get(ch));
            } else {
                map.put(ch, 1);
            }
        }
    }
    
    /**
     * 226. Invert Binary Tree
     * This problem was inspired by this original tweet by Max Howell:
     * Google: 90% of our engineers use the software you wrote (Homebrew),
     * but you can’t invert a binary tree on a whiteboard so fuck off.
     * bug-free
     *
     * @param root treeNode
     * @return root
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        doInvertTree(root);
        return root;
    }
    
    /**
     * 递归 swap(left,right)
     *
     * @param node treeNode
     */
    private void doInvertTree(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null || node.right != null) {
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        doInvertTree(node.left);
        doInvertTree(node.right);
    }
    
    /**
     * 349. Intersection of Two Arrays
     * compute two arrays intersection
     *
     * @param nums1 int[]
     * @param nums2 int[]
     * @return int[] 两个数组公共的元素
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[]{};
        }
        List<Integer> resultList = new ArrayList<Integer>();
        Set<Integer> set1 = new HashSet<Integer>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            if (set1.contains(i)) {
                resultList.add(i);
                set1.remove(i);
            }
        }
        if (resultList.size() == 0) {
            return new int[]{};
        } else {
            int[] arr = new int[resultList.size()];
            for (int i = 0; i < resultList.size(); i++) {
                arr[i] = resultList.get(i);
            }
            return arr;
        }
    }
    
    /**
     * A:      a1 → a2
     * ↘
     * c1 → c2 → c3
     * ↗
     * B: b1 → b2 → b3
     * bug-free
     *
     * @param headA listnode
     * @param headB listnode
     * @return the intersectionNode c1
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode head = headA;
        int lenA = 0;
        while (head.next != null) {
            lenA++;
            head = head.next;
        }
        head = headB;
        int lenB = 0;
        while (head.next != null) {
            lenB++;
            head = head.next;
        }
        ListNode head1;
        ListNode head2;
        if (lenA > lenB) {
            head1 = headA;
            head2 = headB;
        } else {
            head1 = headB;
            head2 = headA;
        }
        int sub = Math.abs(lenA - lenB);
        while (sub > 0) {
            head1 = head1.next;
            sub--;
        }
        
        while (head1 != null && head2 != null) {
            if (head1 == head2) {
                return head1;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        
        return null;
    }
    
    public boolean isPowerOfFour(int num) {
        if (num <= 0) {
            return false;
        }
        if (num == 1) {
            return true;
        }
        while (num > 1) {
            int n = num % 4;
            if (n != 0) {
                return false;
            }
            num = num >> 1 >> 1;
        }
        return true;
    }
    
    //不能直接遍历string, charAt ,拼接新的字符串,当非常长的时候, time limit exceeded
    //将String转换成char[]
    public String reverseString(String s) {
        if (s == null || s.isEmpty() || s.length() == 1) {
            return s;
        }
        char[] arr = s.toCharArray();
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            arr[i] = (char) (arr[i] ^ arr[j]);
            arr[j] = (char) (arr[i] ^ arr[j]);
            arr[i] = (char) (arr[i] ^ arr[j]);
//            char ch = arr[i];
//            arr[i] = arr[j];
//            arr[j] = ch;
            i++;
            j--;
        }
        return new String(arr);
    }
    
    //just reverse 元音字母 aeiou
    //two pointer
    public String reverseVowels(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        char[] arr = s.toCharArray();
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            char c1 = s.charAt(i);
            while (!isVowels(c1)) {
                i++;
                if (i > j) break;
                c1 = s.charAt(i);
            }
            if (i >= j) break;
            char c2 = s.charAt(j);
            while (!isVowels(c2)) {
                j--;
                if (j < 0) break;
                c2 = s.charAt(j);
            }
            //交换i j
            char ch = arr[i];
            arr[i] = arr[j];
            arr[j] = ch;
            i++;
            j--;
        }
        return new String(arr);
    }
    
    private boolean isVowels(char ch) {
        return ch == 'a' || ch == 'A' ||
                ch == 'e' || ch == 'E' ||
                ch == 'i' || ch == 'I' ||
                ch == 'o' || ch == 'O' ||
                ch == 'u' || ch == 'U';
    }
    
    
    public boolean isBalanced(TreeNode root) {
        treeDepth(root);
        if (root == null) {
            return true;
        }
        int l = 0, r = 0;
        if (root.left != null) {
            l = root.left.val;
        }
        if (root.right != null) {
            r = root.right.val;
        }
        if (Math.abs(l - r) <= 1 && isBalanced(root.left) && isBalanced(root.right)) {
            return true;
        }
        return false;
    }
    
    //利用TreeNode val记录二叉树深度
    private int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        root.val = Math.max(treeDepth(root.left), treeDepth(root.right)) + 1;
        return root.val;
    }
    
    //判断二叉树是否平衡
    public boolean isBalanced2(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        
        if (Math.abs(maxDepth(root.left) - maxDepth(root.right)) > 1) {
            return false;
        }
        return isBalanced2(root.left) && isBalanced2(root.right);
    }
    
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
//        return left > right ? (left + 1) : (right + 1);
//        return 1 + (left > right ? left : right);
        return 1 + Math.max(left, right);
    }
    
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            if (l2 == null) {
                return l1;
            }
            if (l1 == null) {
                return l2;
            }
        }
        ListNode head = null;
        while (l1 != null && l2 != null) {
            int v1 = l1.val;
            int v2 = l2.val;
            if (v1 > v2) {
                if (head == null) {
                    head = l2;
                }
                while (l2.next != null && l2.next.val < v1) {
                    l2 = l2.next;
                }
                ListNode tmp = l2.next;
                l2.next = l1;
                l2 = tmp;
            } else {
                if (head == null) {
                    head = l1;
                }
                while (l1.next != null && l1.next.val <= v2) {
                    l1 = l1.next;
                }
                ListNode tmp = l1.next;
                l1.next = l2;
                l1 = tmp;
            }
        }
        
        return head;
    }
    
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        
    }
    
    
    //求最大和,不能取连续的两个数 dp
    //http://www.meetqun.com/thread-8777-1-1.html
    //http://www.meetqun.com/thread-8176-1-1.html
    public int rob(int[] nums) {
        int take = 0;
        int notake = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            take = notake + nums[i]; //偷第i个
            notake = max; //不偷第i个
            max = Math.max(take, notake); //比较取最大值
        }
        return max;
    }
    
    //主要使用了Integer类的静态工具类 JDK实现
    public int reverseBits(int n) {
        String nstr = Integer.toBinaryString(n);
        if (nstr.length() < 32) {
            int num = 32 - nstr.length();
            for (int i = 0; i < num; i++) {
                nstr = "0" + nstr;
            }
        }
        
        String mstr = "";
        for (int i = nstr.length() - 1; i >= 0; i--) {
            mstr += nstr.charAt(i);
        }
        return Integer.parseUnsignedInt(mstr, 2);
    }
    
    
    public boolean wordPattern2(String pattern, String str) {
        String[] arr = str.split("\\s");
        if (arr.length != pattern.length()) {
            return false;
        }
        //两个map判断是否一致
        Map<Character, String> map1 = new HashMap<Character, String>();
        Map<String, Character> map2 = new HashMap<String, Character>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String s = arr[i];
            String tmps = map1.get(c);
            if (tmps != null && !tmps.equals(arr[i])) {
                return false;
            }
            Character tmpc = map2.get(s);
            if (tmpc != null && tmpc != c) {
                return false;
            }
            
            map1.put(c, s);
            map2.put(s, c);
        }
        
        return true;
    }
    
    
    public boolean wordPattern(String pattern, String str) {
        String[] arr = str.split("\\s");
        if (arr.length != pattern.length()) {
            return false;
        }
        //用set size 判断是否一致
        Set<Character> charSet = new HashSet<Character>();
        Set<String> strSet = new HashSet<String>();
        Map<Character, String> map = new HashMap<Character, String>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String tmp = map.get(c);
            if (tmp != null && !tmp.equals(arr[i])) {
                return false;
            } else {
                map.put(c, arr[i]);
                charSet.add(c);
                strSet.add(arr[i]);
            }
        }
        if (charSet.size() != strSet.size()) {
            return false;
        }
        
        return true;
    }
    
    //复制node值 再删除
    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }
    
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode pre = head;
        ListNode node = head.next;
        while (node != null) {
            int v = node.val;
            if (v == val) {
                pre.next = node.next;
            } else {
                pre = node;
            }
            node = node.next;
        }
        return head;
    }
    
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = head;
        ListNode node = head.next;
        while (node != null) {
            int v1 = pre.val;
            int v2 = node.val;
            if (v1 == v2) {
                pre.next = node.next;
            } else {
                pre = node;
            }
            node = node.next;
        }
        return head;
    }
    
    //菲波那切数列
    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int s0 = 1;
        int s1 = 1;
        int s2 = 0;
        for (int i = 2; i <= n; i++) {
            s2 = s0 + s1;
            s0 = s1;
            s1 = s2;
        }
        return s2;
    }
    
    public int lengthOfLastWord(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        s = s.trim();
        int len = s.length();
        int res = 0;
        for (int i = len - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (!Character.isWhitespace(c)) {
                res++;
                continue;
            }
            break;
        }
        return res;
    }
    
    private static ListNode initList(int n) {
        ListNode head = new ListNode(1);
        ListNode node = head;
        for (int i = 2; i <= n; i++) {
            ListNode tmp = new ListNode(i);
            if (i > 5) {
                tmp = new ListNode(10 - i);
            }
            
            node.next = tmp;
            node = tmp;
            
        }
        return head;
    }
    
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
    
    
    static class ListNode {
        int val;
        ListNode next;
        
        ListNode(int x) {
            val = x;
        }
    }
    
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int val) {
            this.val = val;
        }
    }
}
