package com.js.rxjava.chapter3;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

public class L08_SubscribeOnSample {
    public static void main(String[] args) throws InterruptedException {
        Flowable.just(1, 2, 3, 4, 5)
                .subscribeOn(Schedulers.computation())
                .subscribeOn(Schedulers.single())
                .subscribeOn(Schedulers.io())
                .subscribe(data -> {
                    String threadName = Thread.currentThread().getName();
                    System.out.println(threadName + ": " + data);
                });

        Thread.sleep(500);
    }
}
