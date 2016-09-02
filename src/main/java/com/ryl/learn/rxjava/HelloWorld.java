package com.ryl.learn.rxjava;

import rx.Observable;

/**
 * Created on 16/8/10 上午10:54.
 */
public class HelloWorld {

    public static void main(String[] args) {
        hello("Ben", "George", "John");
    }

    public static void hello(String... names) {
        Observable.from(names).subscribe(s -> {
            System.out.println("Hello " + s + "!");
        });
    }

    public static void tests() {
        Observable<String> o = Observable.just("a", "b", "c");
    }
}
