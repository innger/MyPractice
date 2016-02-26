package com.ryl.learn.puzzlers;

// 循环引用 

public class A {
    private B b = new B();

    public A() {
        System.out.println("constructor A");
    }

    public static void main(String[] args) {
        A a = new A();
        System.out.println("finished");
    }
}
