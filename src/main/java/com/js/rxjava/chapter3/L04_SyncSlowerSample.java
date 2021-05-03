package com.js.rxjava.chapter3;

import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;

public class L04_SyncSlowerSample {
    public static void main(String[] args) throws InterruptedException {
        Flowable.interval(1000L, TimeUnit.MILLISECONDS)
                .doOnNext(data -> System.out.println("emit: " + System.currentTimeMillis() + "밀리초: " + data))
                .subscribe(data -> Thread.sleep(2000L));

        Thread.sleep(5000L);
    }
}
