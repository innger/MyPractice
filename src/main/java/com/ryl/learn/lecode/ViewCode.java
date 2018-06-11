package com.ryl.learn.lecode;

import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Map;

/**
 * Created on 2018/6/4 11:01.
 */
public class ViewCode {
    
    
    @Test
    public void isPalindromeTest() {
        System.out.println(isPalindrome(1221));
        System.out.println(isPalindrome(12321));
        System.out.println(isPalindrome(123));
        System.out.println(isPalindrome(-1221));
        System.out.println(isPalindrome(110));
        System.out.println(isPalindrome(0));
    }
    
    /**
     * 判断一个数是否回文数
     * 1221 true
     * 12321 true
     * 123 false  -1221 false
     * 110
     * 求一半数字，判断是否相等
     *
     * @param x int
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x % 10 == 0 && x != 0)
            return false;
        int half = 0;
        while (x > half) {
            half = half * 10 + x % 10;
            x /= 10;
        }
        return half == x || (x == (half / 10));
    }
    
    @Test
    public void lengthOfLongestSubstringTest() {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("aaabbbccc"));
    }
    
    /**
     * 无重复字符的最长子串
     */
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        Map<Character, Integer> map = Maps.newHashMap();
        for (int i = 0, j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if (map.containsKey(c)) {
                i = Math.max(i, map.get(c) + 1);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(c, j);
        }
        return ans;
    }
    
    @Test
    public void longestPalindromeTest() {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
    }
    
    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = centerLen(s, i, i);
            int len2 = centerLen(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > (end - start)) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
                System.out.println("## "+s.substring(start, end + 1));
            }
        }
        return s.substring(start, end + 1);
    }
    
    private int centerLen(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        //不是right-left+1
        return right - left - 1;
    }
    
}
