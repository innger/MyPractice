package com.ryl.learn.jdk8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by renyulong on 16/1/25.
 */
public class ConcurrentTest {

    public static final Logger logger = LoggerFactory.getLogger("ConcurrentTest.logger");

    public static AtomicLong nextNumber = new AtomicLong(0);


    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService es = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 20; i++) {
//            es.execute(new MyThread());
            Future<String> future = es.submit(new MyTask(i));
            logger.info("{} = {}", i, future.get());
        }

        es.awaitTermination(2, TimeUnit.SECONDS);
        logger.info("{} number={} finish.",Thread.currentThread().getName(), nextNumber.incrementAndGet());
        es.shutdown();
    }


    static class MyThread implements Runnable {

        public void run() {
            for (int i = 0; i < 10; i++) {
                logger.info("{} number={}",Thread.currentThread().getName(), nextNumber.incrementAndGet());
            }
        }
    }

    static class MyTask implements Callable<String> {

        private int num;

        public MyTask (int num) {
            this.num = num;
        }

        @Override
        public String call() throws Exception {
            logger.debug("MyTask call begin.");
            TimeUnit.MILLISECONDS.sleep(1 * 1000);
            logger.info("MyTask call finish.");
            return "ok "+num;
        }
    }

}
