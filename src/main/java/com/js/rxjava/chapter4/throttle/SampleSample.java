package com.js.rxjava.chapter4.throttle;

import com.js.rxjava.DebugSubscriber;
import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;

public class SampleSample {

    public static void main(String[] args) throws InterruptedException {
        Flowable<Long> flowable = Flowable.interval(300L, TimeUnit.MILLISECONDS)
                .take(9)
                .sample(Flowable.interval(1000L, TimeUnit.MILLISECONDS));

        flowable.subscribe(new DebugSubscriber<>());

        Thread.sleep(3000L);
    }
}
