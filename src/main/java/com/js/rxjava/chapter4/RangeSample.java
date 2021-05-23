package com.js.rxjava.chapter4;

import com.js.rxjava.DebugSubscriber;
import io.reactivex.Flowable;

public class RangeSample {

    public static void main(String[] args) {
        Flowable<Integer> flowable = Flowable.range(10, 3);
        flowable.subscribe(new DebugSubscriber<>());
    }
}
