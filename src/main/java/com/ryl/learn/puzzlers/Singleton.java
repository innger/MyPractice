package com.ryl.learn.puzzlers;


public class Singleton {

    private Singleton() {
        System.out.println("Singleton init...");
    }

    public static Singleton getInstance() {
        return SingletonContainer.instance;
    }

    public static void main(String[] args) {
        System.out.println("test");
        Singleton.getInstance();
        Singleton.getInstance();
    }

    private static class SingletonContainer {
        private static final Singleton instance = new Singleton();
    }
}
