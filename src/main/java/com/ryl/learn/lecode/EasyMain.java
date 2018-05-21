package com.ryl.learn.lecode;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.*;

/**
 * easy problem 001
 * Created by renyulong on 16/1/25.
 */
public class EasyMain {
    
    public static void main(String[] args) {
        EasyMain easy = new EasyMain();
        ListNode head = new ListNode(1);
        ListNode node = head;
        for (int i = 2; i <= 5; i++) {
            node.next = new ListNode(i);
            node = node.next;
        }
        easy.printListNode(head);
        System.out.println(easy.thirdMax(new int[]{1, 2, 3}));
        
    }
    
    /**
     * 414. Third Maximum Number
     * 求数组中第三大的数,如果不存在,则返回最大的数字
     *
     * @param nums int[] non-empty Array of Integers
     * @return int
     */
    public int thirdMax(int[] nums) {
        int len = nums.length;
        Set<Integer> set = new TreeSet<Integer>();
        for (int i = 0; i < len; i++) {
            set.add(nums[i]);
        }
        int size = set.size();
        Integer[] arr = new Integer[size];
        set.toArray(arr);
        if (size < 3) {
            //返回最大值
            return arr[size - 1];
        }
        return arr[size - 3];
    }
    
    /**
     * 438. Find All Anagrams in a String
     * find all the start indices of p's anagrams in s.
     * anagrams 重组排列组合
     * 所有字符均为小写,s和p的长度不超过20100
     * 动态更改smap
     *
     * @param s string
     * @param p string non-empty
     * @return list.integer
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new LinkedList<Integer>();
        if (s == null || s.length() == 0 || s.length() < p.length()) {
            return result;
        }
        int len = p.length();
        int index = 0;
        Map<Character, Integer> pmap = buildMap(p, index, len);
        Map<Character, Integer> smap = buildMap(s, index, len);
        if (pmap.equals(smap)) {
            result.add(index);
        }
        int begin = index;
        int end = begin + len;
        int slen = s.length();
        while (end < slen) {
            char char1 = s.charAt(begin);
            char char2 = s.charAt(end);
            Integer count = smap.get(char1);
            if (count == 1) smap.remove(char1);
            else smap.put(char1, count - 1);
            count = smap.get(char2);
            if (count == null) count = 0;
            smap.put(char2, count + 1);
            if (pmap.equals(smap)) {
                result.add(begin + 1);
            }
            begin++;
            end++;
        }
        return result;
    }
    
    private Map<Character, Integer> buildMap(String s, int b, int e) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int len = s.length();
        for (int i = b; i < e; i++) {
            char ch = s.charAt(i);
            Integer count = map.get(ch);
            if (count == null) {
                count = 0;
            }
            map.put(ch, count + 1);
        }
        return map;
    }
    
    
    /**
     * 412. Fizz Buzz
     * 根据输入的数字n,输出1-n代表的string list
     * 3的倍数输出Fizz,5的倍数输出Buzz,既是3的倍数,也是5的倍数,输出FizzBuzz
     * Is this problem a joke?
     *
     * @param n int
     * @return list.string
     */
    public List<String> fizzBuzz(int n) {
        List<String> list = new LinkedList<String>();
        if (n < 1) {
            return list;
        }
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                list.add("FizzBuzz");
            } else if (i % 5 == 0) {
                list.add("Buzz");
            } else if (i % 3 == 0) {
                list.add("Fizz");
            } else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }
    
    //判断一个数独是否合法
    public boolean isValidSudoku(char[][] board) {
        int rowValid[] = new int[10];
        int colValid[][] = new int[9][10];
        int subValid[][] = new int[9][10];
        
        for (int i = 0; i < 9; i++) {
            Arrays.fill(rowValid, 0);
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (!checkValid(rowValid, board[i][j] - '0') || !checkValid(colValid[j], board[i][j] - '0')
                            || !checkValid(subValid[i / 3 * 3 + j / 3], board[i][j] - '0'))
                        return false;
                }
            }
        }
        return true;
    }
    
    private boolean checkValid(int[] vec, int val) {
        if (vec[val] == 1) return false;
        vec[val] = 1;
        return true;
    }
    
    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }
        if (haystack.length() == 0 && needle.length() == 0) {
            return 0;
        }
        
        if (needle.length() == 0) {
            return 0;
        }
        return haystack.indexOf(needle);

//      TimeLimit 不行,直接用jdk api 内部实现更高效
//        for (int i = 0; i < haystack.length(); i++) {
//            boolean flag = true;
//            for (int j = 0; j < needle.length(); j++) {
//                char c1 = needle.charAt(j);
//
//                if (haystack.length() <= i + j) {
//                    flag = false;
//                    break;
//                }
//                char c2 = haystack.charAt(i + j);
//                if (c1 != c2) {
//                    flag = false;
//                    break;
//                }
//            }
//            if (flag) {
//                return i;
//            }
//        }
//        return -1;
    }
    
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length < 1) {
            return "";
        }
        
        String res = "";
        for (int i = 0; i < strs[0].length(); i++) {
            boolean flag = true;
            char c1 = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() <= i) {
                    flag = false;
                    break;
                }
                char c2 = strs[j].charAt(i);
                if (c1 != c2) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res += c1;
            } else {
                break;
            }
        }
        return res;
    }
    
    //http://www.cnblogs.com/ganganloveu/p/4193373.html
    // n!尾部0的个数 5的幂次
    public int trailingZeroes(int n) {
        int ret = 0;
        while (n > 0) {
            ret += n / 5;
            n /= 5;
        }
        return ret;
    }
    
    //A-Z 1-26 进制转换
    public String convertToTitle(int n) {
        String res = "";
        boolean init = false;
        while (n > 0) {
            int t = n % 26;
            char c = (char) (t + 64);
            if (t == 0) {
                c = 'Z';
                n = n - 26;
            }
            res = c + res;
            n = n / 26;
            init = true;
        }
        return res;
    }
    
    public int titleToNumber(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int n = c - 64;
            res = res * 26 + n;
        }
        return res;
    }
    
    public String getHint(String secret, String guess) {
        Map<Character, Integer> map1 = new HashMap<Character, Integer>();
        Map<Character, Integer> map2 = new HashMap<Character, Integer>();
        String s2 = "";
        int bull = 0;
        int cows = 0;
        for (int i = 0; i < secret.length(); i++) {
            char c1 = secret.charAt(i);
            char c2 = guess.charAt(i);
            if (c1 == c2) {
                bull++;
            } else {
                Integer tmp = map1.get(c1);
                if (tmp == null) {
                    map1.put(c1, 1);
                } else {
                    map1.put(c1, tmp + 1);
                }
                
                tmp = map2.get(c2);
                if (tmp == null) {
                    map2.put(c2, 1);
                } else {
                    map2.put(c2, tmp + 1);
                }
            }
        }
        for (Character c : map1.keySet()) {
            Integer i1 = map1.get(c);
            Integer i2 = map2.get(c);
            if (i2 != null && i2 > 0) {
                cows += i1 < i2 ? i1 : i2;
            }
        }
        return bull + "A" + cows + "B";
        
    }
    
    //单链表反转
    public ListNode reverseListLoop(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode node = head;
        ListNode pre = null;
        ListNode reverseHead = null;
        while (node != null) {
            ListNode next = node.next;
            if (next == null) {
                reverseHead = node;
            }
            node.next = pre;
            pre = node;
            node = next;
        }
        
        return reverseHead;
    }
    
    //递归方式
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode reversHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        
        return reversHead;
    }
    
    //查找 <= n 的质数个数 The Sieve of Eratosthenes
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }
        // Loop's ending condition is i * i < n instead of i < sqrt(n)
        // to avoid repeatedly calling an expensive function sqrt().
        for (int i = 2; i * i < n; i++) {
            if (!isPrime[i]) continue;
            for (int j = i * i; j < n; j += i) {
                isPrime[j] = false;
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }
        return count;
    }
    
    
    //出现无限循环,用set判断之前是否重复出现过
    public boolean isHappy(int n) {
        int s = 0;
        Set<Integer> set = new HashSet<Integer>();
        while (true) {
            while (n > 0) {
                int d = n % 10;
                n = n / 10;
                s += d * d;
            }
//            System.out.println(s);
            if (s == 1 || set.contains(s)) {
                break;
            }
            set.add(s);
            n = s;
            s = 0;
        }
        return s == 1;
    }
    
    
    //二分查找 找mid值溢出问题考虑
    public int firstBadVersion(int n) {
        int i = 1;
        int j = n;
        while (i <= j) {
            // m = (i+j) / 2 可能int溢出
            int m = i + (j - i) / 2;
            if (isBadVersion(m)) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return i;
    }
    
    boolean isBadVersion(int version) {
//        return new Random().nextInt() % 2 == 0;
        if (version >= 2) {
            return true;
        }
        return false;
    }
    
    public int addDigits(int num) {
        while (num >= 10) {
            int sum = 0;
            int tmp = num;
            while (tmp > 0) {
                int t = tmp % 10;
                tmp = tmp / 10;
                sum += t;
            }
            num = sum;
        }
        return num;
    }
    
    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }
        while (num % 2 == 0) {
            num = num / 2;
        }
        while (num % 3 == 0) {
            num = num / 3;
        }
        while (num % 5 == 0) {
            num = num / 5;
        }
        return num == 1;
    }
    
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        ListNode q = head;
        for (int i = 0; i < n; i++) {
            q = q.next;
        }
        while (q != null && q.next != null) {
            q = q.next;
            p = p.next;
        }
        //删除头结点
        if (q == null) {
            return p.next;
        }
        //删除第n个节点
        if (p.next != null) {
            p.next = p.next.next;
        }
        return head;
    }
    
    //http://blog.csdn.net/ljiabin/article/details/39968583
    public int romanToInt(String s) {
        int res = romanChar2Number(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int i1 = romanChar2Number(s.charAt(i - 1));
            int i2 = romanChar2Number(s.charAt(i));
            if (i1 < i2) {
                res += i2 - 2 * i1;
            } else {
                res += i2;
            }
        }
        return res;
    }
    
    private int romanChar2Number(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 1;
        }
    }
    
    public boolean isPalindrome(int x) {
        int origin = x;
        if (x < 0) origin = -x;
        int re = 0;
        while (x > 0) {
            int t = x % 10;
            re = re * 10 + t;
            x = x / 10;
        }
        return origin == re;
    }
    
    public int hammingWeight(int n) {
        int cnt = 0;
        while (n > 0) {
            cnt++;
            n = (n - 1) & n;
        }
        return cnt;
    }
    
    public boolean isPowerOfTwo(int n) {
        //二进制表示中只有一个1
        if (n < 2 && n != 1) return false;
        int tmp = n;
        int cnt = 0;
        while (true) {
            cnt += tmp & 1;
            tmp = tmp >> 1;
            if (tmp == 0) {
                break;
            }
        }
        return cnt == 1;
    }
    
    public boolean isPowerOfThree(int n) {
        if (n < 3 && n != 1) return false;
        int tmp = n;
        while (tmp > 1) {
            if (tmp % 3 == 0) {
                tmp = tmp / 3;
            } else {
                return false;
            }
        }
        return true;
    }
    
    /**
     * 328. Odd Even Linked List
     * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
     * Given 1->2->3->4->5->NULL,
     * return 1->3->5->2->4->NULL.
     *
     * @param head ListNode
     * @return head ListNode
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null;
        ListNode tmp = head;
        ListNode head2 = head.next;
        ListNode next = tmp.next;
        int i = 0;
        while (next != null) {
            tmp.next = next.next;
            pre = tmp;
            tmp = next;
            next = tmp.next;
            i++;
        }
        if ((i & 1) != 0) {
            if (pre != null) {
                pre.next = head2;
            }
        } else {
            tmp.next = head2;
        }
        return head;
    }
    
    //byr上看到另外的解法,调试一下
    public ListNode oddEvenList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        ListNode second = head.next;
        ListNode nxt = head.next;
        while (cur.next != null) {
            cur.next = cur.next.next;
            if (cur.next != null)
                cur = cur.next;
        }
        //第一个while循环完,链表断开,需要在一个循环里连接好两个链表
        //这部分有问题，但不知道为什么4出不来；
        while (nxt.next != null) {
            nxt.next = nxt.next.next;
            if (nxt.next != null)
                nxt = nxt.next;
        }
        cur.next = second;
        return head;
    }
    
    
    private void printListNode(ListNode head) {
        ListNode tmp = head;
        while (tmp != null) {
            System.out.print(tmp.val + "->");
            tmp = tmp.next;
        }
        System.out.println("null");
    }
    
    public String countAndSay(int n) {
        String res = "1";
        for (int k = 0; k < n - 1; k++) {
            String tmp = "";
            int c = 1;
            char ch = res.charAt(0);
            for (int i = 1; i < res.length(); i++) {
                if (ch == res.charAt(i)) {
                    c++;
                } else {
                    tmp = tmp + c + ch;
                    ch = res.charAt(i);
                    c = 1;
                }
            }
            tmp += "" + c + ch;
            res = tmp;
        }
        return res;
    }
    
    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int i = 0;
        int j = 0;
        while (i < arr1.length && j < arr2.length) {
            int v1 = Integer.parseInt(arr1[i]);
            int v2 = Integer.parseInt(arr2[j]);
            if (v1 > v2) {
                return 1;
            }
            if (v1 < v2) {
                return -1;
            }
            i++;
            j++;
        }
        while (i < arr1.length) {
            if (Integer.parseInt(arr1[i]) == 0) {
                i++;
                continue;
            } else {
                return 1;
            }
        }
        while (j < arr2.length) {
            if (Integer.parseInt(arr2[j]) == 0) {
                j++;
                continue;
            } else {
                return -1;
            }
        }
        return 0;
    }
    
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        String res = "";
        int c = 0;
        while (i >= 0 || j >= 0) {
            int aa = 0;
            if (i >= 0) {
                aa = a.charAt(i) - '0';
            }
            int bb = 0;
            if (j >= 0) {
                bb = b.charAt(j) - '0';
            }
            int tmp = aa ^ bb ^ c;
            res = tmp + res;
            if ((aa + bb + c) >= 2) {
                c = 1;
            } else {
                c = 0;
            }
            
            i--;
            j--;
        }
        if (c > 0) {
            res = c + res;
        }
        return res;
    }
    
    public int myAtoi(String str) {
        str = str.trim();
        String newStr = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (i == 0 && (ch == '-' || ch == '+')) {
                newStr += ch;
                continue;
            }
            if (ch >= '0' && ch <= '9') {
                newStr += ch;
            } else {
                break;
            }
        }
        Long res = 0L;
        boolean positive = true;
        for (int i = 0; i < newStr.length(); i++) {
            char ch = newStr.charAt(i);
            if (i == 0) {
                if (ch == '+') {
                    continue;
                }
                if (ch == '-') {
                    positive = false;
                    continue;
                }
            }
            int t = Character.digit(ch, 10);
            if (positive) {
                res = res * 10 + t;
                if (res >= Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
            } else {
                res = res * 10 - t;
                if (res <= Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            }
        }
        return res.intValue();
    }
    
    public int majorityElement(int[] nums) {
        int m = nums[0];
        int cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == m) {
                cnt++;
            } else {
                cnt--;
            }
            
            if (cnt <= 0) {
                m = nums[i];
                cnt = 1;
            }
        }
        return m;
    }
    
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] tmpArr = new int[m + n];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                tmpArr[k++] = nums1[i++];
            } else {
                tmpArr[k++] = nums2[j++];
            }
        }
        
        while (i < m) {
            tmpArr[k++] = nums1[i++];
        }
        while (j < n) {
            tmpArr[k++] = nums2[j++];
        }
        System.arraycopy(tmpArr, 0, nums1, 0, m + n);
        
    }
    
    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] == 0) {
                boolean flag = true;
                for (int j = i; j < nums.length - 1; j++) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                    if (nums[j] == 0 && nums[j + 1] == 0) {
                        flag = flag && true;
                    } else {
                        flag = flag && false;
                    }
                }
                if (flag) {
                    break;
                }
            }
        }
        
        System.out.println(Arrays.toString(nums));
    }
    
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex < 0) return new ArrayList<Integer>();
        List<List<Integer>> list = generate(rowIndex + 1);
        return list.get(rowIndex);
    }
    
    public List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) return new ArrayList<List<Integer>>();
        List<List<Integer>> list = new ArrayList<List<Integer>>(numRows);
        for (int i = 0; i < numRows; i++) {
            List<Integer> subList = new ArrayList<Integer>(i + 1);
            if (i - 1 >= 0) {
                List<Integer> tmpList = list.get(i - 1);
                for (int j = -1; j < tmpList.size(); j++) {
                    int m = 0;
                    int n = 0;
                    if (j < 0)
                        m = 0;
                    else
                        m = tmpList.get(j);
                    if (j + 1 == tmpList.size())
                        n = 0;
                    else
                        n = tmpList.get(j + 1);
                    subList.add(m + n);
                }
            } else {
                subList.add(1);
            }
            list.add(subList);
        }
        return list;
    }
    
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int[] res;
        int flag = 1;
        int i = len - 1;
        boolean is = false;
        for (; i >= 0; i--) {
            int tmp = digits[i] + flag;
            if (tmp < 10) {
                digits[i] = tmp;
                is = true;
                break;
            } else {
                flag = 1;
                digits[i] = tmp - 10;
            }
        }
        if (i > 0 || (i == 0 && is)) {
            res = new int[len];
            System.arraycopy(digits, 0, res, 0, len);
        } else {
            res = new int[len + 1];
            res[0] = 1;
            System.arraycopy(digits, 0, res, 1, len);
        }
        return res;
    }
    
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int i = 0;
        int j = 1;
        while (i < nums.length && j < nums.length) {
            if (nums[i] == nums[j]) {
                len--;
            } else {
                i++;
                nums[i] = nums[j];
            }
            j++;
        }
        return len;
    }
    
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int i = 0;
        int j = len - 1;
        while (i <= j) {
            if (nums[i] == val) {
                len--;
                nums[i] = nums[j];
                j--;
            } else {
                i++;
            }
        }
        return len;
    }
    
    public int reverse(int x) {
        String tmp = String.valueOf(x);
        String prefix = null;
        String res = "";
        for (int i = 0; i < tmp.length(); i++) {
            char c = tmp.charAt(i);
            if (c >= '0' && c <= '9') {
                res = c + res;
            } else {
                prefix = String.valueOf(c);
            }
        }
        if (prefix != null) {
            res = prefix + res;
        }
        try {
            return Integer.parseInt(res);
        } catch (Exception e) {
            return 0;
        }
        
    }
    
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[k - i - 1] = nums[nums.length - 1 - i];
        }
        for (int i = nums.length - 1 - k, j = nums.length - 1; i >= 0; i--, j--) {
            nums[j] = nums[i];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = arr[i];
        }
        printArray(nums);
        
    }
    
    private void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        if (nums == null || nums.length < 1) {
            return res;
        }
        if (nums.length == 1) {
            res.add(nums[0] + "");
            return res;
        }
        
        int i = 0;
        int j = i + 1;
        while (i < nums.length && j <= nums.length) {
            if (j < nums.length && nums[j - 1] + 1 == nums[j]) {
                j++;
            } else {
                if (j - i > 1) {
                    res.add(nums[i] + "->" + nums[j - 1]);
                } else {
                    res.add(nums[j - 1] + "");
                }
                i = j;
                j = i + 1;
            }
        }
        return res;
    }
    
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length < 1) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int t = nums[i];
            if (map.get(t) != null) {
                if (i - map.get(t) <= k) {
                    return true;
                }
            }
            map.put(t, i);
        }
        return false;
        
        
    }
    
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length < 1) {
            return false;
        }
        Set<Integer> set = new HashSet<Integer>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
    
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        List<Integer> sList = new ArrayList<Integer>(s.length());
        List<Integer> tList = new ArrayList<Integer>(t.length());
        for (int i = 0; i < s.length(); i++) {
            sList.add(s.indexOf(s.charAt(i)));
            tList.add(t.indexOf(t.charAt(i)));
        }
        System.out.println(sList);
        System.out.println(tList);
        for (int i = 0; i < s.length(); i++) {
            if (sList.get(i) != tList.get(i)) {
                return false;
            }
        }
        return true;
    }
    
    
    @Test
    public void isIsomorphicTest() {
        Lists.newArrayList(
                isIsomorphic("egg", "add"),
                isIsomorphic("foo", "bar"),
                isIsomorphic("paper", "title"),
                isIsomorphic("ab", "aa"),
                isIsomorphic("yy", "xx")).forEach(System.out::println);
    }
    
    public boolean isIsomorphic2(String s, String t) {
        Map<Character, Character> stMap = Maps.newHashMap();
        Map<Character, Character> tsMap = Maps.newHashMap();
        for (int i = 0; i < s.length(); i++) {
            char schar = s.charAt(i);
            char tchar = t.charAt(i);
            
            if (stMap.get(schar) == null && tsMap.get(tchar) == null) {
                stMap.put(schar, tchar);
                tsMap.put(tchar, schar);
            } else if (stMap.get(schar) == null || stMap.get(schar) != tchar || 
                    tsMap.get(tchar) == null || tsMap.get(tchar) != schar) {
                return false;
            }
        }
        return true;
    }
    
    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char a = s.charAt(i);
            if ((a >= '0' && a <= '9') || (a >= 'A' && a <= 'Z') || (a >= 'a' && a <= 'z')) {
                
            } else {
                i++;
                continue;
            }
            
            char b = s.charAt(j);
            if ((b >= '0' && b <= '9') || (b >= 'A' && b <= 'Z' || (b >= 'a') && b <= 'z')) {
                
            } else {
                j--;
                continue;
            }
            
            if (a >= '0' && a <= '9') {
                if (a != b) {
                    return false;
                } else {
                    i++;
                    j--;
                    continue;
                }
                
            } else {
                if (a == b || (a + 32) == b || (a - 32) == b) {
                    i++;
                    j--;
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                case ']':
                case '}':
                    if (stack.isEmpty()) return false;
                    char tmpc = stack.pop();
                    if (tmpc == '(' && c == ')' || tmpc == '[' && c == ']' || tmpc == '{' && c == '}') {
                        continue;
                    } else {
                        return false;
                    }
                default:
                    return false;
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
        
    }
    
    /**
     * 不构造二维数组,直接拼字符串
     * easy and clear ( interesting approach )
     * really nice solution
     *
     * @param str string
     * @param n   int
     * @return string
     */
    public String zigZag2(String str, int n) {
        if (n <= 1) return str;
        StringBuilder[] sb = new StringBuilder[n]; //n行
        for (int i = 0; i < n; i++) {
            sb[i] = new StringBuilder("");
        }
        int incre = 1; //控制方向
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            sb[index].append(str.charAt(i));
            if (index == 0) {
                incre = 1;
            }
            if (index == n - 1) {
                incre = -1;
            }
            index += incre;
        }
        String res = "";
        for (int i = 0; i < n; i++) {
            res += sb[i];
        }
        return res;
    }
    
    /**
     * a   e   i
     * b d f h j
     * c   g   k
     * <p>
     * 构造一个zigZag二维数组,在顺序拼起来
     *
     * @param str string
     * @param n   int
     * @return string
     */
    
    public String zigZag(String str, int n) {
        if (n == 1) {
            return str;
        }
        
        int x = 0, y = 0;
        int step = 2 * (n - 1);
        boolean s2 = false;
        int max = str.length();
        char[][] matrix = new char[max][n];
        
        for (int i = 0; i < str.length(); i++) {
            int k = i % step;
            if (k < n) {
                if (s2) {
                    s2 = false;
                    x++;
                    y--;
                }
                System.out.println("-----" + x + "," + y);
                matrix[x][y] = str.charAt(i);
                if (y < n - 1) {
                    y++;
                } else {
                    s2 = true;
                }
            } else {
                y--;
                x++;
                System.out.println("+++++" + x + "," + y);
                matrix[x][y] = str.charAt(i);
                s2 = true;
            }
        }
        String res = "";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < max; j++) {
                char c = matrix[j][i];
                if (c != 0) {
                    res += c;
                }
            }
        }
        return res;
    }
    
    public static class ListNode {
        int val;
        ListNode next;
        
        ListNode(int x) {
            this.val = x;
        }
    }
}
