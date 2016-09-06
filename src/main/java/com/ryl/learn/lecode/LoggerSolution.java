package com.ryl.learn.lecode;

import java.util.HashMap;
import java.util.Map;

/**
 * 359. Logger Rate Limiter
 * Design a logger system that receive stream of messages along with its timestamps,
 * each message should be printed if and only if [[it is not printed in the last 10 seconds.]]
 * Given a message and a timestamp (in seconds granularity), return true if the message should be printed in the given timestamp, otherwise returns false.
 * It is possible that several messages arrive roughly at the same time.
 * <p>
 * Created on 16/9/6 上午9:59.
 */
public class LoggerSolution {

    private Map<String, Integer> map;

    public LoggerSolution() {
        map = new HashMap<String, Integer>();
    }

    /**
     * if and only if [[it is not printed in the last 10 seconds.]]
     *
     * @param timestamp int
     * @param message   string
     * @return boolean
     */
    private boolean shouldPrintMessage(int timestamp, String message) {
        if (!map.containsKey(message) || timestamp - map.get(message) >= 10) {
            map.put(message, timestamp);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LoggerSolution logger = new LoggerSolution();
        // logging string "foo" at timestamp 1
        System.out.println(logger.shouldPrintMessage(1, "foo"));

        // logging string "bar" at timestamp 2
        System.out.println(logger.shouldPrintMessage(2, "bar"));

        // logging string "foo" at timestamp 3
        System.out.println(logger.shouldPrintMessage(3, "foo"));

        // logging string "bar" at timestamp 8
        System.out.println(logger.shouldPrintMessage(8, "bar"));

        // logging string "foo" at timestamp 10
        System.out.println(logger.shouldPrintMessage(10, "foo"));

        // logging string "foo" at timestamp 11
        System.out.println(logger.shouldPrintMessage(11, "foo"));
    }
}