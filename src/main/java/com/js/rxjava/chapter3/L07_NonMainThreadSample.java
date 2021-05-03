package com.js.rxjava.chapter3;

import io.reactivex.Flowable;
import io.reactivex.subscribers.ResourceSubscriber;

import java.util.concurrent.TimeUnit;

public class L07_NonMainThreadSample {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("start");

        Flowable.interval(300L, TimeUnit.MILLISECONDS)
                .subscribe(new ResourceSubscriber<>() {
                    @Override
                    public void onNext(Long data) {
                        String threadName = Thread.currentThread().getName();
                        System.out.println(threadName + ": " + data);
                    }

                    @Override
                    public void onComplete() {
                        String threadName = Thread.currentThread().getName();
                        System.out.println(threadName + ": 완료");
                    }

                    @Override
                    public void onError(Throwable t) {
                        t.printStackTrace();
                    }
                });

        System.out.println("end");

        Thread.sleep(1000L);
    }
}
