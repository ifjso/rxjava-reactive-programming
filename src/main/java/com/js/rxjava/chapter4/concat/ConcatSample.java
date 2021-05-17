package com.js.rxjava.chapter4.concat;

import com.js.rxjava.chapter4.DebugSubscriber;
import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;

public class ConcatSample {

    public static void main(String[] args) throws InterruptedException {
        Flowable<Long> flowable1 = Flowable.interval(300L, TimeUnit.MILLISECONDS)
                .take(5);

        Flowable<Long> flowable2 = Flowable.interval(500L, TimeUnit.MILLISECONDS)
                .take(2)
                .map(data -> data + 100L);

        Flowable<Long> result = Flowable.concat(flowable1, flowable2);

        result.subscribe(new DebugSubscriber<>());

        Thread.sleep(3000L);
    }
}
