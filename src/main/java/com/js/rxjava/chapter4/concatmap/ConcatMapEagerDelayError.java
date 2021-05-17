package com.js.rxjava.chapter4.concatmap;

import com.js.rxjava.chapter4.DebugSubscriber;
import io.reactivex.Flowable;
import java.util.concurrent.TimeUnit;

public class ConcatMapEagerDelayError {

    public static void main(String[] args) throws InterruptedException {
        Flowable<String> flowable = Flowable.range(10, 3)
            .concatMapEagerDelayError(
                sourceData -> Flowable.interval(500L, TimeUnit.MILLISECONDS)
                    .take(3)
                    .doOnNext(data -> {
                        if (sourceData == 11 && data == 1) {
                            throw new Exception("예외 발생");
                        }
                    })
                    .map(data -> "[" + sourceData + "] " + data),
                true);

        flowable.subscribe(new DebugSubscriber<>());

        Thread.sleep(4000L);
    }
}
