package com.ryl.learn.lecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 288. Unique Word Abbreviation
 * 单词的唯一缩写
 * An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:
 * it                      --> it
 * d|o|g                   --> d1g
 * i|nternationalizatio|n  --> i18n
 * l|ocalizatio|n          --> l10n
 * <p>
 * Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary.
 * A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.
 * <p>
 * Created on 16/9/6 下午3:59.
 */
public class ValidWordAbbr {

    private Map<String, List<String>> map = new HashMap<String, List<String>>();

    public ValidWordAbbr(List<String> dictionary) {
        for (String word : dictionary) {
            if (word.length() <= 2) continue;
            int num = word.length() - 2;
            String abb = word.charAt(0) + String.valueOf(num) + word.charAt(word.length() - 1);
            List<String> list = map.get(abb);
            if (list != null) {
                list.add(word);
            } else {
                list = new ArrayList<String>();
                list.add(word);
                map.put(abb, list);
            }
        }
    }

    public boolean isUnique(String word) {
        int num = word.length() - 2;
        String abb = word.charAt(0) + String.valueOf(num) + word.charAt(word.length() - 1);
        List<String> list = map.get(abb);
        if (list == null) return true;
        return list.size() == 1 && list.get(0).equals(word);
    }

    public static void main(String[] args) {
        List<String> dict = new ArrayList<String>();
        dict.add("deer");
        dict.add("door");
        dict.add("cake");
        dict.add("card");
        ValidWordAbbr wordAbbr = new ValidWordAbbr(dict);
        System.out.println(wordAbbr.isUnique("dear"));
        System.out.println(wordAbbr.isUnique("cart"));
        System.out.println(wordAbbr.isUnique("cane"));
        System.out.println(wordAbbr.isUnique("make"));
    }
}
