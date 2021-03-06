package com.js.rxjava.chapter4;

import com.js.rxjava.DebugSubscriber;
import io.reactivex.Flowable;

public class EmptySample {

    public static void main(String[] args) {
        Flowable
                .empty()
                .subscribe(new DebugSubscriber<>());
    }
}
