package com.ryl.learn.util;

import com.alibaba.fastjson.JSON;
import com.lmax.disruptor.*;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * https://tech.meituan.com/disruptor.html
 * Created on 2018/5/16 10:50.
 */
public class DisruptorMain {
    
    public static void main(String[] args) throws InterruptedException {
        class Element {
            private int value;
            
            public int get() {
                return value;
            }
            
            public void set(int value) {
                this.value = value;
            }
        }
        
        
        ThreadFactory threadFactory = r -> new Thread(r, "simpleThread");
        
        //RingBuffer生产工厂,初始化RingBuffer的时候使用
        EventFactory<Element> factory = Element::new;
        
        //处理Event的handler
        EventHandler<Element> handler = (element, sequence, endOfBatch) -> System.out.println("Element: " + element.get());
        
        //阻塞策略
        BlockingWaitStrategy strategy = new BlockingWaitStrategy();
        
        //指定RingBuffer的大小
        int bufferSize = 16;
        
        //创建disruptor，采用单生产者模式
        Disruptor<Element> disruptor = new Disruptor<>(factory, bufferSize, threadFactory, ProducerType.SINGLE, strategy);
        
        //设置EventHandler
        disruptor.handleEventsWith(handler);
        
        //启动disruptor的线程
        disruptor.start();
        
        RingBuffer<Element> ringBuffer = disruptor.getRingBuffer();
        
        ringBuffer.publishEvent(new EventTranslator<Element>() {
            @Override
            public void translateTo(Element element, long l) {
                
            }
        });
        
        for (int l = 0; true; l++) {
            // 获取下一个可用位置的下标
            long sequence = ringBuffer.next();
            try {
                // 返回可用位置的元素
                Element event = ringBuffer.get(sequence);
                // 设置该位置元素的值
                event.set(l);
            } finally {
                ringBuffer.publish(sequence);
            }
            Thread.sleep(10);
        }
    }
    
    
    private static void print() {
        //方法中定义类
        @Data
        @AllArgsConstructor
        class Node {
            private Integer key;
            private String value;
        }
        
        System.out.println(new Node(1, "one"));
        
    }
    
    
    final class ValueEvent {
        
        public ValueEvent() {
        }
        
        private long value;
        
        public long getValue()
        {
            return value;
        }
        
        public void setValue(final long value)
        {
            this.value = value;
        }
    }
    
    @Test
    public void disruptorTest() {
    
        final EventFactory<ValueEvent> EVENT_FACTORY = ValueEvent::new;
        final ThreadFactory THREAD_FACTORY = r -> new Thread(r, "simpleThread");
        
        Disruptor<ValueEvent> disruptor =
                new Disruptor<>(EVENT_FACTORY, 32, THREAD_FACTORY, ProducerType.SINGLE, new SleepingWaitStrategy());
        disruptor.handleEventsWith((EventHandler<ValueEvent>) (valueEvent, l, b) -> 
                System.out.println(String.format("handle1 %s %d", JSON.toJSONString(valueEvent), l)))
            .handleEventsWith((EventHandler<ValueEvent>) (event, l, b) -> 
                    System.out.println(String.format("handler2 %d %d", event.getValue(), l)))
        ;
        RingBuffer<ValueEvent> ringBuffer = disruptor.start();
        
        ExecutorService service = Executors.newFixedThreadPool(20);
    
        for (int i = 0; i < 20; i++) {
            service.submit((Runnable) () -> {
                while(true) {
                    long seq = ringBuffer.next();
                    ValueEvent value = ringBuffer.get(seq);
                    processValue(value);
                    ringBuffer.publish(seq);
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void processValue(ValueEvent event) {
        ValueEvent valueEvent = new ValueEvent();
        valueEvent.setValue(new Random().nextLong());
        BeanUtils.copyProperties(valueEvent, event);
    }
}
