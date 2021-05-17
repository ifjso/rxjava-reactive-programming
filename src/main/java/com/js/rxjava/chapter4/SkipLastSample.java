package com.js.rxjava.chapter4;

import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;

public class SkipLastSample {

    public static void main(String[] args) throws InterruptedException {
        Flowable<Long> flowable = Flowable.interval(1000L, TimeUnit.MILLISECONDS)
                .take(5)
                .skipLast(2);

        flowable.subscribe(new DebugSubscriber<>());

        Thread.sleep(6000L);
    }
}
