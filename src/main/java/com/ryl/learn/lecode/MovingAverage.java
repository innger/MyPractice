package com.ryl.learn.lecode;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 346. Moving Average from Data Stream
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 * <p>
 * Created on 16/9/6 上午10:09.
 */
public class MovingAverage {

    private int len;
    private double sum;
    private Queue<Integer> queue;

    public MovingAverage(int len) {
        this.len = len;
        sum = 0.0;
        queue = new ArrayBlockingQueue<Integer>(len + 1);
    }

    double next(int val) {
        sum += val;
        queue.offer(val);
        if (queue.size() > len) {
            sum -= queue.poll();
        }
        return sum / queue.size();
    }

    public static void main(String[] args) {
        MovingAverage m = new MovingAverage(3);
        System.out.println(m.next(1));
        System.out.println(m.next(10));
        System.out.println(m.next(3));
        System.out.println(m.next(5));
    }

}
