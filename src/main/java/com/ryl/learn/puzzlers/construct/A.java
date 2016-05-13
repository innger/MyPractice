package com.ryl.learn.puzzlers.construct;

/**
 *  类初始化
 *  加载 -> 链接 -> 初始化
 */
public class A {

    private B b = new B();

    {
        System.out.println("A init");
    }

    static {
        System.out.println("A init static");
    }

    public A() {
        //初始化类,最后执行构造函数
        System.out.println("A constructor");
    }

    public static void main(String[] args) {
        A a = new A();
        System.out.println("finished");
    }
}
