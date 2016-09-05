package com.ryl.learn.concurent;

import java.util.concurrent.TimeUnit;

/**
 * Created on 16/9/5 上午11:27.
 */
public class NoPublish {
    /*volatile*/ boolean stop = false;

    public static void main(String[] args) {
        NoPublish demo = new NoPublish();
        Thread thread = new Thread(demo.getConcurrencyCheckTask());
        thread.setDaemon(false);
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Set stop to true in main!");
        demo.stop = true;
        System.out.println("Exit main.");
    }

    private ConcurrencyCheckTask getConcurrencyCheckTask () {
        return new ConcurrencyCheckTask();
    }

    private class ConcurrencyCheckTask implements Runnable {

        @Override
        public void run() {
            System.out.println("ConcurrencyCheckTask started!");
            // 如果主线中stop的值可见，则循环会退出。
            // 在开发机上，几乎必现循环不退出！（简单安全的解法：在running属性上加上volatile）
            while(!stop) {

            }
            System.out.println("ConcurrencyCheckTask stopped!");
        }
    }
}
