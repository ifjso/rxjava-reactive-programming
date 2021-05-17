package com.js.rxjava.chapter4.repeat;

import com.js.rxjava.chapter4.DebugSubscriber;
import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;

public class RepeatUntilSample {

    public static void main(String[] args) throws InterruptedException {
        final long startTime = System.currentTimeMillis();

        Flowable<Long> flowable = Flowable.interval(100L, TimeUnit.MILLISECONDS)
                .take(3)
                .repeatUntil(() -> {
                    System.out.println("called");
                    return System.currentTimeMillis() - startTime > 500L;
                });

        flowable.subscribe(new DebugSubscriber<>());

        Thread.sleep(1000L);
    }
}
