package com.js.rxjava.chapter4;

import com.js.rxjava.DebugSingleObserver;
import io.reactivex.Flowable;
import io.reactivex.Single;

import java.util.concurrent.TimeUnit;

public class AllSample {

    public static void main(String[] args) throws InterruptedException {
        Single<Boolean> single = Flowable.interval(1000L, TimeUnit.MILLISECONDS)
                .take(3)
                .all(data -> data < 5);

        single.subscribe(new DebugSingleObserver<>());

        Thread.sleep(4000L);
    }
}
