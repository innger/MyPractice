package com.ryl.learn.concurent;

/**
 * Created on 16/9/5 上午11:15.
 */
public class InvalidLong {
    long count = 0;

    public static void main(String[] args) {
        InvalidLong demo = new InvalidLong();
        Thread thread = new Thread(demo.getConcurrencyCheckTask());
        thread.start();

        for (int i = 0; ; i++) {
            long l = i;
            demo.count = l << 32 | l;
        }
    }

    private ConcurrencyCheckTask getConcurrencyCheckTask() {
        return new ConcurrencyCheckTask();
    }

    private class ConcurrencyCheckTask implements Runnable {

        @Override
        public void run() {
            int c = 0;
            for (int i = 0; ; i++) {
                long l = count;
                long high = l >>> 32;
                long low = l & 0xFFFFFFFFL;
                if (high != low) {
                    c++;
                    System.out.printf("Got invalid long! check time=%s, happen time=%s(%s%%), count value=%s|%s\n",
                            i + 1, c, (float) c / (i + 1) * 100, high, low);
                } else {
                    //如果去掉这个输出,没有观察到invalid long输出
                    System.out.printf("Emm... %s|%s\n", high, low);
                }
            }
        }
    }
}
