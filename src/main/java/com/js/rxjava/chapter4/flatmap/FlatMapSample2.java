package com.js.rxjava.chapter4.flatmap;

import com.js.rxjava.chapter4.DebugSubscriber;
import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;

public class FlatMapSample2 {

    public static void main(String[] args) throws InterruptedException {
        Flowable<String> flowable = Flowable.range(1, 3)
                .flatMap(
                        data -> Flowable.interval(100L, TimeUnit.MILLISECONDS).take(3),
                        (sourceData, newData) -> "[" + sourceData + "] " + newData);

        flowable.subscribe(new DebugSubscriber<>());

        Thread.sleep(1000L);
    }
}
