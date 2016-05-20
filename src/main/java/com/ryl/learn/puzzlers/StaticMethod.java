package com.ryl.learn.puzzlers;

public class StaticMethod {

    public static void main(String[] args) {
        ((StaticMethod) null).greet();   //静态方法 不使用实例 调用方法 使用类型
        ((StaticMethod) null).greet1(); //java.lang.NullPointerException NPE
    }

    //静态方法 使用类名访问
    public static void greet() {
        System.out.println("Hello World! static greet");
    }

    public void greet1() {
        System.out.println("Hello World! non static greet1");
    }
}
