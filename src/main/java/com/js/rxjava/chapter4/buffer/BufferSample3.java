package com.js.rxjava.chapter4.buffer;

import com.js.rxjava.chapter4.DebugSubscriber;
import io.reactivex.Flowable;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BufferSample3 {

    public static void main(String[] args) throws InterruptedException {
        Flowable<List<Long>> flowable = Flowable.interval(300L, TimeUnit.MILLISECONDS)
            .take(7)
            .buffer(
                Flowable.interval(1000L, TimeUnit.MILLISECONDS),
                i -> Flowable.timer(1000L, TimeUnit.MILLISECONDS)
            );

        flowable.subscribe(new DebugSubscriber<>());

        Thread.sleep(4000L);
    }
}
