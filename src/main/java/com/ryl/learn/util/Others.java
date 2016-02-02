package com.ryl.learn.util;

/**
 * Created by renyulong on 16/1/27.
 */
public class Others {

    public static void main(String[] args){
        System.out.println("".length());
        System.out.println((byte)11);
        System.out.println("================");
        byte[] byteArr = "\uffff".getBytes();
        System.out.println(byteArr.length);
        for(byte b : byteArr){
            System.out.println(b);
        }

    }
}
