package com.ryl.learn.puzzlers;

import java.util.concurrent.atomic.AtomicLong;


public class T55 {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            Creature1 creature = new Creature1();
        }// for 局部变量声明语句
        System.out.println(Creature1.numCreated());
    }

    static class Creature {
        private static long numCreated = 0;

        public Creature() {
            synchronized (Creature.class) {
                numCreated++;
            }

        }

        public static synchronized long numCreated() {
            return numCreated;
        }
    }

    //jdk5 新增的 原子类型变量 不要需要额外的线程同步
    static class Creature1 {
        private static AtomicLong numCreated = new AtomicLong();

        public Creature1() {
            numCreated.incrementAndGet();
        }

        public static long numCreated() {
            return numCreated.get();
        }
    }
}




