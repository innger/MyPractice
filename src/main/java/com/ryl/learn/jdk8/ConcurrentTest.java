package com.ryl.learn.jdk8;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by renyulong on 16/1/25.
 */
public class ConcurrentTest {

    public static AtomicLong nextNumber = new AtomicLong(0);


    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(20);
        for(int i = 0;i < 20 ;i++){
            es.execute(new MyThread());
        }

        es.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println(Thread.currentThread().getName()+" finish."+nextNumber.incrementAndGet());
    }


    static class MyThread implements Runnable {

        public void run() {
            for(int i = 0;i<10;i++) {
                System.out.println(Thread.currentThread().getName() + " number=" + nextNumber.incrementAndGet());
            }
        }
    }

}
