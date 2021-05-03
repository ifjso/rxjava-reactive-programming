package com.js.rxjava.chapter3;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;

import java.util.concurrent.TimeUnit;

public class L09_ObserveOnSample1 {
    public static void main(String[] args) throws InterruptedException {
        Flowable<Long> flowable = Flowable.interval(300L, TimeUnit.MILLISECONDS)
                .onBackpressureDrop();
        flowable
                .observeOn(Schedulers.computation(), false, 2)
                .subscribe(new ResourceSubscriber<>() {
                    @Override
                    public void onNext(Long data) {
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            System.exit(1);
                        }

                        String threadName = Thread.currentThread().getName();
                        System.out.println(threadName + ": " + data);
                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onError(Throwable t) {

                    }
                });

        Thread.sleep(7000L);
    }
}
