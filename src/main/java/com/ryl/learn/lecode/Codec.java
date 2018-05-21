package com.ryl.learn.lecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 535. Encode and Decode TinyURL
 * 简短url
 * https://leetcode.com/problems/design-tinyurl -> http://tinyurl.com/4e9iAk
 * <p>
 * [a-zA-Z0-9] 62进制的6位数字
 * <p>
 * Created on 17/3/6 10:45.
 */
public class Codec {
    
    private final String prefix = "http://tinyurl.com/";
    private Map<Integer, Character> dicMap = new HashMap<>();
    private Map<Character, Integer> dicMap2 = new HashMap<>();
    
    {
        String dicStr = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        for (int i = 0; i < 62; i++) {
            char ch = dicStr.charAt(i);
            dicMap.put(i, ch);
            dicMap2.put(ch, i);
        }
    }
    
    private Map<Integer, String> map = new HashMap<>();
    
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int id = map.size() + 1;
        map.put(id, longUrl);
        List<Integer> value = new ArrayList<>();
        while (id > 0) {
            int remainder = id % 62;
            value.add(remainder);
            id = id / 62;
        }
        String shortUrl = "";
        for (int i = value.size() - 1; i >= 0; i--) {
            shortUrl = dicMap.get(value.get(i)) + shortUrl;
        }
        if (shortUrl.length() < 6) {
            shortUrl = dicMap.get(0) + shortUrl;
        }
        return prefix + shortUrl;
    }
    
    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        shortUrl = shortUrl.replace(prefix, "");
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < shortUrl.length(); i++) {
            nums.add(dicMap2.get(shortUrl.charAt(i)));
        }
        for (int i = 1; i <= 6 - nums.size(); i++) {
            nums.add(0, 0);
        }
        
        int id = 0;
        int size = nums.size();
        for (int i = 0; i < size; i++) {
            int value = nums.get(i);
            id += (int) (value * Math.pow(62, size - i - 1));
        }
        return map.get(id);
    }
    
    public static void main(String[] args) {
        // Your Codec object will be instantiated and called as such:
        String url = "https://leetcode.com/problems/design-tinyurl";
        Codec codec = new Codec();
        System.out.println(codec.encode(url));
        String res = codec.decode(codec.encode(url));
        System.out.println(res);
    }
}
