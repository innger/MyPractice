package com.ryl.learn.concurent;

import java.util.Random;

/**
 * Created on 16/9/5 上午11:05.
 */
public class InvalidCombinationState {

    public static void main(String[] args) {
        CombinationStateTask task = new CombinationStateTask();
        Thread thread = new Thread(task);
        thread.start();

        Random random = new Random();
        while (true) {
            int rand = random.nextInt(1000);
            task.state1 = rand;
            task.state2 = rand * 2;
        }
    }

    private static class CombinationStateTask implements Runnable {
        //对于组合状态,volatile不能解决问题
        volatile int state1;
        volatile int state2;

        @Override
        public void run() {
            int c = 0;
            for (long i = 0; ; i++) {
                int i1 = state1;
                int i2 = state2;
                if (i1 * 2 != i2) {
                    c++;
                    System.out.printf("Got invalid CombinationState check time=%s, happen time=%s(%s%%), count value=%s|%s\n",
                            i + 1, c, (float) c / (i + 1) * 100, i1, i2);
                } else {
                    //有没有这个输出,对输出概率有影响 ???
                    System.out.printf("Emm... %s|%s\n", i1, i2);
                }
            }
        }
    }
}
