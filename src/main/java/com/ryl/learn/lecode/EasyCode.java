package com.ryl.learn.lecode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by renyulong on 16/3/8.
 */
public class EasyCode {

    public static void main(String[] args) {
        EasyCode code = new EasyCode();
//        System.out.println(code.climbStairs(10));

        ListNode list1 = initList(5);
        ListNode list2 = initList(5);
        printList(code.mergeTwoLists(list1, list2));

        //00000010100101000001111010011100
//        System.out.println(code.reverseBits(43261596));

//        System.out.println(code.rob(new int[]{1, 2, 3, 4, 5, 6}));
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
            node.next = tmp;
            node = tmp;
            /*if (i % 2 == 0) {
                tmp = new ListNode(1);
                node.next = tmp;
                node = tmp;
            }*/
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
