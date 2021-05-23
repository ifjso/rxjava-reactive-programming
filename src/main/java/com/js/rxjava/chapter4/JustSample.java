package com.js.rxjava.chapter4;

import com.js.rxjava.DebugSubscriber;
import io.reactivex.Flowable;

public class JustSample {

    public static void main(String[] args) {
        Flowable<String> flowable = Flowable.just("A", "B", "C", "D", "E");
        flowable.subscribe(new DebugSubscriber<>());
    }
}
