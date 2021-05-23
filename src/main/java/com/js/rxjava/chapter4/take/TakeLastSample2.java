package com.js.rxjava.chapter4.take;

import com.js.rxjava.DebugSubscriber;
import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;

public class TakeLastSample2 {

    public static void main(String[] args) throws InterruptedException {
        Flowable<Long> flowable = Flowable.interval(300L, TimeUnit.MILLISECONDS)
                .take(10)
                .takeLast(2, 1000L, TimeUnit.MILLISECONDS);

        flowable.subscribe(new DebugSubscriber<>());

        Thread.sleep(4000L);
    }
}
