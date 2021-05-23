package com.js.rxjava.chapter4.repeat;

import com.js.rxjava.DebugSubscriber;
import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;

public class RepeatWhenSample2 {

    public static void main(String[] args) throws InterruptedException {
        Flowable<String> flowable = Flowable.interval(100L, TimeUnit.MILLISECONDS)
                .take(3)
                .repeatWhen(completeHandler -> completeHandler
                        .delay(1000L, TimeUnit.MILLISECONDS)
                        .take(2)
                        .doOnNext(data -> System.out.println("emit: " + data))
                        .doOnComplete(() -> System.out.println("complete")))
                .map(data -> {
                    long time = System.currentTimeMillis();
                    return time + "ms: " + data;
                });

        flowable.subscribe(new DebugSubscriber<>());

        Thread.sleep(5000L);
    }
}
