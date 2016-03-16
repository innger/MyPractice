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

//        ListNode head = initList(2);
//        printList(head);
//        printList(code.removeElements(head, 2));

        //00000010100101000001111010011100
        System.out.println(code.reverseBits(43261596));
    }

    public int rob(int[] nums) {
        //Todo
        return 0;
    }

    //主要使用了Integer类的静态工具类 JDK实现
    public int reverseBits(int n) {
        String nstr = Integer.toBinaryString(n);
        if (nstr.length() < 32) {
            int num = 32 - nstr.length();
            for (int i = 0; i < num; i++) {
                nstr = "0"+nstr;
            }
        }

        String mstr = "";
        for (int i = nstr.length() - 1; i >= 0; i--) {
            mstr += nstr.charAt(i);
        }
        return Integer.parseUnsignedInt(mstr,2);
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
            ListNode tmp = new ListNode(1);
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

}
