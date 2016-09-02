package com.ryl.learn.util;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created on 16/9/2 上午11:09.
 */
public class SpeedLimiter {

    private AtomicInteger sended;
    private long timestamp;

    private long timeSpan = 1 * 1000L;
    private int limit = 1;

    private RateLimiter rateLimiter;

    public SpeedLimiter() {
        sended = new AtomicInteger(0);
        timestamp = System.currentTimeMillis();
        rateLimiter = RateLimiter.create(1.0); // 每秒多少token
    }

    public synchronized void speedLimit() throws InterruptedException {
        sended.getAndIncrement();
        long currentTime = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + " " + currentTime + " speed sended=" + sended);
        long deltaTime = currentTime - timestamp;
        if (deltaTime <= timeSpan) {
            if (sended.get() >= limit) {
                long sleepTime = timeSpan - deltaTime;
                if (sleepTime > 0) {
                    System.out.println(Thread.currentThread().getName() + " Thread sleep " + sleepTime + "ms");
                    Thread.sleep(sleepTime);
                }
                sended.set(0);
                timestamp = System.currentTimeMillis();
            }
        } else {
            System.out.println("should not limit speed");
            sended.set(0);
            timestamp = currentTime;
        }
    }

    public void speedLimit(RateLimiter rateLimiter) {
        System.out.println(Thread.currentThread().getName() + " " + System.currentTimeMillis() + " speed limit");
        rateLimiter.acquire();
    }

    public static void main(String[] args) throws InterruptedException {
        final SpeedLimiter limiter = new SpeedLimiter();
        Runnable r = () -> {
            for (int i = 0; i < 3; i++) {
                try {
                    limiter.speedLimit();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        for (int i = 0; i < 3; i++) {
            Thread t = new Thread(r);
            t.start();
        }
    }
}
