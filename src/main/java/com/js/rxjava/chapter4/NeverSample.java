package com.js.rxjava.chapter4;

import io.reactivex.Flowable;

public class NeverSample {

    public static void main(String[] args) {
        Flowable
                .never()
                .subscribe(new DebugSubscriber<>());
    }
}
