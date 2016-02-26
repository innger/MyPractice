package com.ryl.learn.puzzlers;

import java.util.ArrayList;
import java.util.List;


interface Type1 {
    //接口里面声明 抛出异常 实现类可以不抛
    void f() throws InterruptedException;

    //接口 没有声明 抛出异常 则实现类中 一定不能抛出异常
    //接口 就是约定
    void h();
}

interface Type2 {
    void f() throws CloneNotSupportedException;
}

interface Type3 extends Type1, Type2 {

}

public class T37 {

    private String test = "i am a private member.";

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("123");
        List<Integer> list1 = new ArrayList<Integer>();
        System.out.println(func(list1));

        T37 t = new T37();
        System.out.println(t.test()); //在类内部 new 对象，可以调用本对象的私有方法
        System.out.println(t.test);
        Arcane3 a = new Arcane3();
        a.f();
        Type1Impl type1 = new Type1Impl();
        type1.f();

    }

//	private static String func(List<String> a){
//		return "a";
//	}

    //异常 不是方法 签名的一部分
//	private int func1() throws Exception{
//		return 1;
//	}
//
//	private int func1() throws Exception{
//		return 1;
//	}

    private static int func(List<Integer> a) {
        return 1;
    }

    private String test() {
        return "i am a private method.";
    }

}

class Arcane3 implements Type3 {

    @Override
    public void f() {
        System.out.println("Hello World!");
    }

    @Override
    public void h() {

    }

}

class Type1Impl implements Type1 {

    @Override
    public void f() {
        System.out.println(" Type1 Impl");
    }

    @Override
    public void h() {

    }

}









