package com.js.rxjava.chapter4.throttle;

import com.js.rxjava.DebugSubscriber;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;

public class ThrottleWithTimeout {

    public static void main(String[] args) {
        Flowable<String> flowable = Flowable.<String>create(emitter -> {
            emitter.onNext("A");
            Thread.sleep(1000L);

            emitter.onNext("B");
            Thread.sleep(300L);

            emitter.onNext("C");
            Thread.sleep(300L);

            emitter.onNext("D");
            Thread.sleep(1000L);

            emitter.onNext("E");
            Thread.sleep(100L);

            emitter.onComplete();
        }, BackpressureStrategy.BUFFER)
                .throttleWithTimeout(500L, TimeUnit.MILLISECONDS);

        flowable.subscribe(new DebugSubscriber<>());
    }
}
