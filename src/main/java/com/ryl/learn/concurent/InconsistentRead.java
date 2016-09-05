package com.ryl.learn.concurent;

/**
 * Created on 16/9/5 上午10:51.
 */
public class InconsistentRead {

    int count = 1;

    public static void main(String[] args) {
        InconsistentRead demo = new InconsistentRead();
        Thread thread = new Thread(demo.getConcurrencyCheckTask());
        thread.start();
        while (true) {
            //主线程对count++
            demo.count++;
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
                //在同一线程连续2次
                int c1 = count;
                int c2 = count;
                if (c1 != c2) {
                    //进程启动时可以观察到一批不一致读
                    c++;
                    System.out.printf("Got inconsistent read check time=%s, happen time=%s(%s%%), 1=%s, 2=%s\n",
                            i + 1, c, (float) c / (i + 1) * 100, c1, c2);
                }
            }
        }
    }
}
