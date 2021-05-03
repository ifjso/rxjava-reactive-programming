package com.js.rxjava.chapter3;

import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;

public class L10_FlatMapSample {
    public static void main(String[] args) throws InterruptedException {
        Flowable<String> flowable = Flowable.just("A", "B", "C", "D", "E", "F", "G", "H", "I", "J")
                .flatMap(data -> Flowable.just(data).delay(1000L, TimeUnit.MILLISECONDS));

        flowable.subscribe(data -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + ": " + data);
        });

        Thread.sleep(2000L);
    }
}
