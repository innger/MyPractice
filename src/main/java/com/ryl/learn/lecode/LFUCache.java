package com.ryl.learn.lecode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * 460. LFU Cache
 * Least Frequently Used (LFU)
 * 最少使用,如果使用频率相等,则用LRU淘汰
 * Created on 17/4/7 11:29.
 */
public class LFUCache {
    
    static class Node {
        private Integer key;
        private Integer value;
        private int counter;
        private int recent;
        
        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return key != null ? key.equals(node.key) : node.key == null;
        }
        
        @Override
        public int hashCode() {
            return key != null ? key.hashCode() : 0;
        }
    
        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    ", counter=" + counter +
                    ", recent=" + recent +
                    '}';
        }
    }
    
    private int time = 0;
    private int capacity;
    private TreeSet<Node> set = new TreeSet<>((Comparator<Node>) (o1, o2) -> {
        if (o1.counter == o2.counter) {
            return o1.recent - o2.recent;
        }
        return o1.counter - o2.counter;
    });
    private Map<Integer, Node> map = new HashMap<>();
    
    public LFUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        time++;
        Node node = map.get(key);
        if (node != null) {
            set.remove(node);
            node.counter++;
            node.recent = time;
            set.add(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        time++;
        Node node = map.get(key);
        boolean add = true;
        if(node == null) {
            node = new Node(key, value);
        } else {
            add = false;
            node.value = value;
            set.remove(node);
        }
        if (add && set.size() == capacity) {
            //remove
            Node n = set.pollFirst();
            if(n == null) return;
            map.remove(n.key);
        }
        node.counter++;
        node.recent = time;
        map.put(key, node);
        set.add(node);
    }
    
    public static void main(String[] args) {
        LFUCache cache = new LFUCache( 2 /* capacity */ );
    
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3.
        cache.put(4, 4);    // evicts key 1.
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
        
        cache = new LFUCache(2);
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        
    }
    
}
