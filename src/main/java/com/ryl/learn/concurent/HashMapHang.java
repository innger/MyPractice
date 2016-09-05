package com.ryl.learn.concurent;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created on 16/9/5 上午10:13.
 * Java HashMap的死循环
 * http://coolshell.cn/articles/9606.html
 */
public class HashMapHang {

    final Map<Integer, String> holder = new HashMap<Integer, String>();

    public static void main(String[] args) {
        HashMapHang demo = new HashMapHang();
        for (int i = 0; i < 10; i++) {
            demo.holder.put(i, Thread.currentThread().getName());
        }
        //HashMap被多线程操作时,有可能出现死循环 并发下的rehash非线程安全
        ExecutorService service = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            service.submit(demo.getConcurrencyCheckTask());
        }

        System.out.println("Start get in main!");
        for (int i = 0; ; i++) {
            for (int j = 0; j < 10000; j++) {
                String value = demo.holder.get(j);
                // 如果出现hashmap的get hang住问题，则下面的输出就不会再出现了。
                // 在我的开发机上，很容易在第一轮就观察到这个问题。
                System.out.printf("Got key=%s value=%s in round %s %d\n", j, value, i, demo.holder.size());
            }
        }
    }


    private ConcurrencyCheckTask getConcurrencyCheckTask() {
        return new ConcurrencyCheckTask();
    }

    private class ConcurrencyCheckTask implements Runnable {

        private Random random = new Random();

        @Override
        public void run() {
            System.out.println("Add loop started in task!");
            while (true) {
                holder.put(random.nextInt() % (1024 * 1024 * 100) , Thread.currentThread().getName());
            }
        }
    }
}
