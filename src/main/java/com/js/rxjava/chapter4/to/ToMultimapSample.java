package com.js.rxjava.chapter4.to;

import com.js.rxjava.DebugSingleObserver;
import io.reactivex.Flowable;
import io.reactivex.Single;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ToMultimapSample {

    public static void main(String[] args) throws InterruptedException {
        Single<Map<String, Collection<Long>>> single = Flowable.interval(500L, TimeUnit.MILLISECONDS)
                .take(5)
                .toMultimap(data -> {
                    if (data % 2 == 0) {
                        return "짝수";
                    }

                    return "홀수";
                });

        single.subscribe(new DebugSingleObserver<>());

        Thread.sleep(3000L);
    }
}
