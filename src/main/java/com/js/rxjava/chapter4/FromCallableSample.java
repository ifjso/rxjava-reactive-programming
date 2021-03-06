package com.js.rxjava.chapter4;

import com.js.rxjava.DebugSubscriber;
import io.reactivex.Flowable;

public class FromCallableSample {

    public static void main(String[] args) {
        Flowable<Long> flowable = Flowable.fromCallable(() -> System.currentTimeMillis());
        flowable.subscribe(new DebugSubscriber<>());
    }
}
