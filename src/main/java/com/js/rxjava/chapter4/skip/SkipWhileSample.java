package com.js.rxjava.chapter4.skip;

import com.js.rxjava.DebugSubscriber;
import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;

public class SkipWhileSample {

    public static void main(String[] args) throws InterruptedException {
        Flowable<Long> flowable = Flowable.interval(300L, TimeUnit.MILLISECONDS)
                .skipWhile(data -> data != 3);

        flowable.subscribe(new DebugSubscriber<>());

        Thread.sleep(2000L);
    }
}
