package com.js.rxjava.chapter4.take;

import com.js.rxjava.chapter4.DebugSubscriber;
import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;

public class TakeSample {

    public static void main(String[] args) throws InterruptedException {
        Flowable<Long> flowable = Flowable.interval(1000L, TimeUnit.MILLISECONDS)
                .take(3);

        flowable.subscribe(new DebugSubscriber<>());

        Thread.sleep(4000L);
    }
}
