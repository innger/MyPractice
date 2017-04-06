package com.ryl.learn.lecode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 146. LRU Cache
 * Least Recently Used (LRU) cache.
 * 近期最少使用 使用LinkedHashMap override removeEldestEntry方法
 * 
 * Created on 17/4/6 14:35.
 */
public class LRUCache {
    
    Map<Integer, Integer> map;
    
    public LRUCache(int capacity) {
        this.map = new LinkedHashMap<Integer,Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }
    
    public int get(int key) {
        return map.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        map.put(key, value);
    }
    
}
