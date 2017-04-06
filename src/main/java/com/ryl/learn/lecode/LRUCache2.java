package com.ryl.learn.lecode;

import java.util.HashMap;
import java.util.Map;

/**
 * 双向链表实现
 * Created on 17/4/6 14:52.
 */
public class LRUCache2 {
    
    //链表节点
    class Node {
        Node pre;
        Node next;
        Integer key;
        Integer value;
        
        Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }
    
    Map<Integer, Node> map = new HashMap<>();
    Node head; //head tail是标示节点,方便插入删除
    Node tail;
    int cap;
    
    public LRUCache2(int capacity) {
        cap = capacity;
        head = new Node(null, null);
        tail = new Node(null, null);
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if (node != null) {
            //将node删除
            node.pre.next = node.next;
            node.next.pre = node.pre;
            appendTail(node);
            return node.value;
        }
        return -1;
    }
    
    public void set(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
//            map.put(key, node);
            node.pre.next = node.next;
            node.next.pre = node.pre;
            appendTail(node);
            return;
        }
        if (map.size() == cap) {
            //从head删除
            Node tmp = head.next;
            head.next = head.next.next;
            head.next.pre = head;
            map.remove(tmp.key);
        }
        //node = null
        node = new Node(key, value);
        appendTail(node);
        map.put(key, node);
    }
    
    //刷新成最近使用的
    private void appendTail(Node n) {
        n.next = tail;
        n.pre = tail.pre;
        tail.pre.next = n;
        tail.pre = n;
    }
    
}

