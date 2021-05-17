package com.js.rxjava.chapter4.to;

import com.js.rxjava.chapter4.DebugSingleObserver;
import io.reactivex.Flowable;
import io.reactivex.Single;

import java.util.List;

public class ToListSample {

    public static void main(String[] args) {
        Single<List<String>> single = Flowable.just("A", "B", "C", "D", "E")
                .toList();

        single.subscribe(new DebugSingleObserver<>());
    }
}
