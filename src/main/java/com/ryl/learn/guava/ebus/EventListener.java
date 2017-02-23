package com.ryl.learn.guava.ebus;

import com.google.common.eventbus.Subscribe;

/**
 * Created on 17/2/23 10:32.
 */
public class EventListener {
    
    
    @Subscribe
    public void handleMessage(String a) {
        System.out.println("######### a=" + a);
    }
    
    @Subscribe
    public void handleMessage2(String b) {
        System.out.println("######### b=" + b);
    }
    
}
