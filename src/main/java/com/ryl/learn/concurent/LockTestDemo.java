package com.ryl.learn.concurent;

import java.util.concurrent.locks.ReentrantLock;

public class LockTestDemo {

    public static void main(String[] args){
        final Count count = new Count();
        for(int i =0;i<5;i++){
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    count.get();
                }
            });
            t.start();

        }


        for(int i=0;i<5;i++){
            Thread a = new Thread(new Runnable() {
                @Override
                public void run() {
                    count.put();
                }
            });
            a.start();

        }

        try {
            Thread.sleep(20*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }
}

class Count {

    ReentrantLock getLock = new ReentrantLock(true);
    ReentrantLock putLock = new ReentrantLock(true);

    public void get(){

        try {
            getLock.lock();
            System.out.println(Thread.currentThread().getName()+" get begin.");
            Thread.sleep(1000L);
            System.out.println(Thread.currentThread().getName()+" get end.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            getLock.unlock();
        }

    }

    public void put(){

        try {
            putLock.lock();
            System.out.println(Thread.currentThread().getName()+" put begin.");
            Thread.sleep(2000L);
            System.out.println(Thread.currentThread().getName()+" put end.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            putLock.unlock();
        }


    }
}
