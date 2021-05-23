package com.js.rxjava.chapter6;

import com.js.rxjava.DebugSubscriber;
import io.reactivex.Flowable;

public class DoOnCompleteSample {

    public static void main(String[] args) {
        Flowable.range(1, 5)
                .doOnComplete(() -> System.out.println("doOnComplete"))
                .subscribe(new DebugSubscriber<>());
    }
}
