package com.js.rxjava.chapter4.take;

import com.js.rxjava.chapter4.DebugSubscriber;
import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;

public class TakeWhile {

    public static void main(String[] args) throws InterruptedException {
        Flowable<Long> flowable = Flowable.interval(300L, TimeUnit.MILLISECONDS)
                .takeWhile(data -> data != 3);

        flowable.subscribe(new DebugSubscriber<>());

        Thread.sleep(2000L);
    }
}
