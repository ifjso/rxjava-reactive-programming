package com.js.rxjava.chapter6;

import com.js.rxjava.DebugSubscriber;
import io.reactivex.Flowable;

public class DoOnNextSample {

    public static void main(String[] args) {
        Flowable.range(1, 5)
                .doOnNext(data -> System.out.println("--- 기존 데이터: " + data))
                .filter(data -> data % 2 == 0)
                .doOnNext(data -> System.out.println("------ filter 적용 후 데이터: " + data))
                .subscribe(new DebugSubscriber<>());
    }
}
