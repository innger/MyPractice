package com.ryl.learn.puzzlers.construct;


public class B {

//    private A a = new A(); //循环引用 java.lang.StackOverflowError
    private static A a = new A(); //静态成员变量

    {
        System.out.println("B init");
    }

    static {
        System.out.println("B init static");
    }

    public B() {
        System.out.println("B constructor");
    }
}
