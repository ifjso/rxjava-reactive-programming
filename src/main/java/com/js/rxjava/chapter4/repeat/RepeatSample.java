package com.js.rxjava.chapter4.repeat;

import com.js.rxjava.DebugSubscriber;
import io.reactivex.Flowable;

public class RepeatSample {

    public static void main(String[] args) {
        Flowable<String> flowable = Flowable.just("A", "B", "C")
                .repeat(2);

        flowable.subscribe(new DebugSubscriber<>());
    }
}
