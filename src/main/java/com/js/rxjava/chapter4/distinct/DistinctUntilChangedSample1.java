package com.js.rxjava.chapter4.distinct;

import com.js.rxjava.chapter4.DebugSubscriber;
import io.reactivex.Flowable;

public class DistinctUntilChangedSample1 {

    public static void main(String[] args) {
        Flowable<String> flowable = Flowable.just("A", "a", "a", "A", "a")
                .distinctUntilChanged();

        flowable.subscribe(new DebugSubscriber<>());
    }
}
