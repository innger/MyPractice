package com.ryl.learn.lecode;

import java.util.HashMap;
import java.util.Map;

/**
 * 170. Two Sum III - Data structure design
 * Design and implement a TwoSum class. It should support the following operations: add and find.
 *
 * add - Add the number to an internal data structure.
 * find - Find if there exists any pair of numbers which sum is equal to the value.
 *
 * add(1); add(3); add(5);
 * find(4) -> true
 * find(7) -> false
 *
 * Created on 16/9/6 下午4:23.
 */
public class TwoSum {

    private Map<Integer,Integer> map = new HashMap<Integer, Integer>();

    public void add(int number) {
        Integer value = map.get(number);
        if(value == null) {
            map.put(number,1);
        } else {
            map.put(number,++value);
        }
    }

    public boolean find(int value) {
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if(value != 2 * entry.getKey() && map.containsKey(value - entry.getKey())) {
                return true;
            }
            if(value == 2 * entry.getKey() && entry.getValue() > 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TwoSum sum = new TwoSum();
        sum.add(1);
        sum.add(3);
        sum.add(5);
        System.out.println(sum.find(4));
        System.out.println(sum.find(7));
        System.out.println(sum.find(6));
        System.out.println(sum.find(10));
    }
}
