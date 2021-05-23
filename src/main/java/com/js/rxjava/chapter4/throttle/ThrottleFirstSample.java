package com.js.rxjava.chapter4.throttle;

import com.js.rxjava.DebugSubscriber;
import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;

public class ThrottleFirstSample {

    public static void main(String[] args) throws InterruptedException {
        Flowable<Long> flowable = Flowable.interval(300L, TimeUnit.MILLISECONDS)
                .take(10)
                .throttleFirst(1000L, TimeUnit.MILLISECONDS);

        flowable.subscribe(new DebugSubscriber<>());

        Thread.sleep(4000L);
    }
}
