package com.js.rxjava.chapter4;

import com.js.rxjava.DebugSingleObserver;
import io.reactivex.Flowable;
import io.reactivex.Single;

public class ReduceSample {

    public static void main(String[] args) {
        Single<Integer> single = Flowable.just(1, 10, 100, 1000, 10000)
                .reduce(0, (sum, data) -> sum + data);

        single.subscribe(new DebugSingleObserver<>());
    }
}
