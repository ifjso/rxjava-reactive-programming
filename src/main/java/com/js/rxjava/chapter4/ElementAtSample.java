package com.js.rxjava.chapter4;

import io.reactivex.Flowable;
import io.reactivex.Maybe;

import java.util.concurrent.TimeUnit;

public class ElementAtSample {

    public static void main(String[] args) throws InterruptedException {
        Maybe<Long> maybe = Flowable.interval(100L, TimeUnit.MILLISECONDS)
                .elementAt(3);

        maybe.subscribe(new DebugMaybeObserver<>());

        Thread.sleep(1000L);
    }
}
