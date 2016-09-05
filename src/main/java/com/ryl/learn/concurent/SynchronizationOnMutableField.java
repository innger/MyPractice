package com.ryl.learn.concurent;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created on 16/9/5 上午11:52.
 */
public class SynchronizationOnMutableField {

    static final int ADD_COUNT = 10000;

    static class Listener {
        //stub class
    }

    private volatile List<Listener> listeners = new CopyOnWriteArrayList<Listener>();

    public static void main(String[] args) throws Exception {
        SynchronizationOnMutableField demo = new SynchronizationOnMutableField();
        Thread t1 = new Thread(demo.getConcurrencyCheckTask());
        t1.start();
        Thread t2 = new Thread(demo.getConcurrencyCheckTask());
        t2.start();

        t1.join();
        t2.join();

        int actualSize = demo.listeners.size();
        int expectedSize = ADD_COUNT * 2;
        if (actualSize != expectedSize) {
            // 在开发机上，几乎必现！（简单安全的解法：final List字段并用并发安全的List，如CopyOnWriteArrayList）
            System.out.printf("Lost update on mutable field! actual %d expected %d.\n", actualSize, expectedSize);
        } else {
            System.out.println("Emm... Got right answer!!");
        }
    }

    public void addListener(Listener listener) {
        synchronized (listeners) {
//            List<Listener> results = new ArrayList<Listener>(listeners);
            List<Listener> results = new CopyOnWriteArrayList<Listener>(listeners);
            results.add(listener);
            listeners = results;
        }
    }

    private ConcurrencyCheckTask getConcurrencyCheckTask() {
        return new ConcurrencyCheckTask();
    }

    private class ConcurrencyCheckTask implements Runnable {

        @Override
        public void run() {
            System.out.println("ConcurrencyCheckTask started!");
            for (int i = 0; i < ADD_COUNT; i++) {
                addListener(new Listener());
            }
            System.out.println("ConcurrencyCheckTask stopped!");
        }
    }
}
