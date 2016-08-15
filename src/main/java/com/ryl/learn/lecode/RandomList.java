package com.ryl.learn.lecode;

import java.util.Random;

/**
 * Created on 16/8/15 上午11:29.
 * Given a singly linked list, return a random node's value from the linked list.
 * Each node must have the same probability of being chosen.
 */
public class RandomList {


    private ListNode head = null;
    private Random rnd = null;

    /**
     * @param head The linked list's head.
     *             Note that the head is guaranteed to be not null, so it contains at least one node.
     */
    public RandomList(ListNode head) {
        this.head = head;
        this.rnd = new Random();
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        ListNode res = null;
        ListNode cur = head;
        for (int n = 1; cur != null; n++) {
            if (rnd.nextInt(n) == 0) {
                res = cur;
            }
            cur = cur.next;
        }
        if(res == null) res = head;
        return res.val;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}


