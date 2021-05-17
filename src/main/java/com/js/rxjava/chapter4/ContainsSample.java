package com.js.rxjava.chapter4;

import io.reactivex.Flowable;
import io.reactivex.Single;

import java.util.concurrent.TimeUnit;

public class ContainsSample {

    public static void main(String[] args) throws InterruptedException {
        Single<Boolean> single = Flowable.interval(1000L, TimeUnit.MILLISECONDS)
                .contains(3L);

        single.subscribe(new DebugSingleObserver<>());

        Thread.sleep(4100L);
    }
}
