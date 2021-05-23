package com.js.rxjava.chapter4.concatmap;

import com.js.rxjava.DebugSubscriber;
import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;

public class ConcatMapSample {

    public static void main(String[] args) throws InterruptedException {
        Flowable<String> flowable = Flowable.range(10, 3)
                .concatMap(
                        sourceData -> Flowable.interval(500L, TimeUnit.MILLISECONDS)
                                .take(2)
                                .map(data -> {
                                    long time = System.currentTimeMillis();
                                    return time + "ms: [" + sourceData + "] " + data;
                                }));

        flowable.subscribe(new DebugSubscriber<>());

        Thread.sleep(4000L);
    }
}
