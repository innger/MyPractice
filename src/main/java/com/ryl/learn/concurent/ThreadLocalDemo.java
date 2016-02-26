package com.ryl.learn.concurent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadLocalDemo {

    public static void main(String[] args) {
        Thread[] runs = new Thread[5];
        T1 t1 = new T1(1);
        for (int i = 0; i < runs.length; i++) {
            runs[i] = new Thread(t1);
        }

        for (int i = 0; i < runs.length; i++) {
            runs[i].start();
        }

        try {
            Thread.sleep(201000);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

    static class T1 implements Runnable {

        private final static ThreadLocal<Map> threadLocalMap = new ThreadLocal<Map>() {
            @Override
            public Map initialValue() {
                return new HashMap();
            }
        };
        int id;

        T1(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            Map map = threadLocalMap.get();
            for (int i = 0; i < 20; i++) {
                map.put(i, i + id*100);
                try {
                    Thread.sleep(10L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " map size = " + map.size() + " # " + map);

        }
    }
}

class BoundedBuffer {
    final Lock lock = new ReentrantLock();
    final Condition notFull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();

    final Object[] items = new Object[100];
    int putptr, takeptr, count;

    public void put(Object x) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length)
                notFull.await();
            items[putptr] = x;
            if (++putptr == items.length) putptr = 0;
            ++count;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0)
                notEmpty.await();
            Object x = items[takeptr];
            if (++takeptr == items.length) takeptr = 0;
            --count;
            notFull.signal();
            return x;
        } finally {
            lock.unlock();
        }
    }
}


