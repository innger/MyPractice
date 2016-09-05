package com.ryl.learn.concurent;

/**
 * Created on 16/9/5 上午11:47.
 */
public class SymmetricLockDeadLock {

    static final Object lock1 = new Object();
    static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(new ConcurrencyCheckTask1());
        t1.start();
        Thread t2 = new Thread(new ConcurrencyCheckTask2());
        t2.start();
    }

    private static class ConcurrencyCheckTask1 implements Runnable {

        @Override
        public void run() {
            System.out.println("ConcurrencyCheckTask1 started!");
            while (true) {
                synchronized (lock1) {
                    synchronized (lock2) {
                        System.out.println("Hello1");
                    }
                }
            }
        }
    }

    private static class ConcurrencyCheckTask2 implements Runnable {

        @Override
        public void run() {
            System.out.println("ConcurrencyCheckTask2 stareted!");
            while(true) {
                synchronized (lock2) {
                    synchronized (lock1) {
                        System.out.println("Hello2");
                    }
                }
            }
        }
    }
}
