package com.ryl.learn.guava.ebus;

import com.google.common.eventbus.EventBus;

/**
 * Created on 17/2/23 10:33.
 */
public class EventMain {
    
    private static final EventBus BUS = new EventBus();
    
    static {
        BUS.register(new EventListener());
    }
    
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            BUS.post("test string");
            System.out.println("==============");
        }
    }
}
