package com.js.rxjava.chapter4;

import io.reactivex.Flowable;

public class MapSample {

    public static void main(String[] args) {
        Flowable<String> flowable = Flowable.just("A", "B", "C", "D", "E")
                .map(String::toLowerCase);
        flowable.subscribe(new DebugSubscriber<>());
    }
}
