package com.ryl.learn.puzzlers;

public class T54 {
    //静态方法 使用 类名访问
    public static void greet() {
        System.out.println("Hello World! greet");
    }

    public static void main(String[] args) {
        ((T54) null).greet();   //静态方法 不使用实例 调用方法 使用类型
        ((T54) null).greet1(); //java.lang.NullPointerException
    }

    public void greet1() {
        System.out.println("Hello World! greet1");
    }
}
