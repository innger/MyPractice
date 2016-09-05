package com.ryl.learn.concurent;

/**
 * Created on 16/9/5 下午12:01.
 */
public class WrongCounter {

    private static final int INC_COUNT = 100000000;

    volatile int counter = 0;

    public static void main(String[] args) throws Exception {
        WrongCounter demo = new WrongCounter();
        System.out.println("Start task thread!");

        Thread t1 = new Thread(demo.getConcurrencyCheckTask());
        t1.start();
        Thread t2 = new Thread(demo.getConcurrencyCheckTask());
        t2.start();

        t1.join();
        t2.join();

        int actualCounter = demo.counter;
        int expectedCounter = INC_COUNT * 2;
        if (actualCounter != expectedCounter) {
            // 在开发机上，几乎必现！即使counter上加了volatile。（简单安全的解法：使用AtomicInteger）
            //volatile只能保证线程的可见性(true/false) 并不保证操作原子性
            System.out.printf("Got wrong count! actual %d, expected %d\n", actualCounter, expectedCounter);
        } else {
            System.out.println("Wow... Got right answer!");
        }

    }

    private ConcurrencyCheckTask getConcurrencyCheckTask() {
        return new ConcurrencyCheckTask();
    }

    private class ConcurrencyCheckTask implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < INC_COUNT; i++) {
                ++counter;
            }
        }
    }
}
