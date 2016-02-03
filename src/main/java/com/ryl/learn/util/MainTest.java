package com.ryl.learn.util;

import java.util.Random;

/**
 * Created by renyulong on 16/1/27.
 */
public class MainTest {

    public static void main(String[] args){
        System.out.println("".length());
        System.out.println((byte)11);
        System.out.println("================");
        byte[] byteArr = "\uffff".getBytes();
        System.out.println(byteArr.length);
        for(byte b : byteArr){
            System.out.println(b);
        }
        //random种子相同,重复执行产生的随机序列相同
        Random random = new Random(10000);
        for (int i = 0; i < 10; i++) {
//            System.out.println(random.nextInt(10000));
        }

    }
}
