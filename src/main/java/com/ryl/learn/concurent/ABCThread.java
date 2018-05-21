package com.ryl.learn.concurent;

import java.util.Objects;

/**
 * 三个线程，循环打印ABC
 * Created on 2018/5/2 12:30.
 */
public class ABCThread {
    
    public static void main(String[] args) {
        
        Thread A = new Thread(new Worker("A", 1));
        Thread B = new Thread(new Worker("B", 2));
        Thread C = new Thread(new Worker("C", 3));
        A.start();B.start();C.start();
        
    }
    
    private static Integer COUNTER = 1;
    private static final Object LOCK = new Object();
    
    private static class Worker implements Runnable {
        
        private String name;
        private Integer num;
    
        public Worker(String name, Integer num) {
            this.name = name;
            this.num = num;
        }
    
        @Override
        public void run() {
            run2();
        }
        
        public void run1() {
            while(true) {
                synchronized (LOCK) {
                    if(Objects.equals(COUNTER, num)) {
                        System.out.println(name);
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        COUNTER++;
                        COUNTER = COUNTER > 3? 1 : COUNTER;
                        LOCK.notifyAll();
                    }
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        
        public void run2() {
            while (true) {
                synchronized (LOCK) {
                    while(!Objects.equals(COUNTER, num)) {
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(name);
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    COUNTER++;
                    COUNTER = COUNTER > 3 ? 1 : COUNTER;
                    LOCK.notifyAll();
                }
            }
        }
        
    }
    
}
