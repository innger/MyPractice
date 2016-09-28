package com.ryl.learn.rxjava;

import rx.Observable;
import rx.Subscriber;

/**
 * Created on 16/8/10 上午10:54.
 */
public class HelloWorld {

    public static void main(String[] args) {
        hello("Ben", "George", "John");
		tests();
    }

    public static void hello(String... names) {
        Observable.from(names).subscribe(s -> {
            System.out.println("Hello " + s + "!");
        });
    }

    public static void tests() {
		Observable<String> myObservable = Observable.create((Observable.OnSubscribe<String>) sub -> {
			sub.onNext("Hello World 1");
			sub.onNext("Hello World 2");
			sub.onNext("Hello World 3");
			sub.onCompleted();
		});
		Subscriber<String> mySubscriber = new Subscriber<String>() {
			@Override
			public void onCompleted() {
				
			}
			
			@Override
			public void onError(Throwable throwable) {
				
			}
			
			@Override
			public void onNext(String s) {
				System.out.println("subscribe receive : "+s);
			}
		};
	
		Observable.just("a", "b", "c").map(s -> s + " by rxjava").subscribe(mySubscriber);
		
		Observable.just("1", "2", "3").map(String::hashCode).subscribe(i -> System.out.println(Integer.toString(i)));
		
		myObservable.subscribe(mySubscriber);
    }
}
