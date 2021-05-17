package com.js.rxjava.chapter4;

import io.reactivex.Flowable;

public class ScanSample {

    public static void main(String[] args) {
        Flowable<Integer> flowable = Flowable.just(1, 10, 100, 1000, 10000)
                .scan(0, (sum, data) -> sum + data);

        flowable.subscribe(new DebugSubscriber<>());
    }
}
