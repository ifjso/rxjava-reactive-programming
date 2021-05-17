package com.js.rxjava.chapter4.delay;

import com.js.rxjava.chapter4.DebugSubscriber;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;

public class DelaySample {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("처리 시작: " + System.currentTimeMillis());

        Flowable<String> flowable = Flowable.<String>create(emitter -> {
            System.out.println("구독 시작: " + System.currentTimeMillis());

            emitter.onNext("A");
            emitter.onNext("B");
            emitter.onNext("C");
            emitter.onComplete();
        }, BackpressureStrategy.BUFFER)
                .delay(2000L, TimeUnit.MILLISECONDS)
                .doOnNext(data -> System.out.println("통지 시각: " + System.currentTimeMillis()));

        flowable.subscribe(new DebugSubscriber<>());

        Thread.sleep(3000L);
    }
}
