package com.js.rxjava.chapter4;

import io.reactivex.Flowable;

import java.util.List;

public class FromArraySample {

    public static void main(String[] args) {
        Flowable<String> arrayFlowable = Flowable.fromArray("A", "B", "C", "D", "E");
        arrayFlowable.subscribe(new DebugSubscriber<>());

        Flowable<String> iterableFlowable = Flowable.fromIterable(List.of("A", "B", "C", "D", "E"));
        iterableFlowable.subscribe(new DebugSubscriber<>());
    }
}
