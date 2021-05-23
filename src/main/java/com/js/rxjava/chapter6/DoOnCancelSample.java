package com.js.rxjava.chapter6;

import io.reactivex.Flowable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.TimeUnit;

public class DoOnCancelSample {

    public static void main(String[] args) throws InterruptedException {
        Flowable.interval(100L, TimeUnit.MILLISECONDS)
                .doOnCancel(() -> System.out.println("doOnCancel"))
                .subscribe(new Subscriber<>() {

                    private long startTime;
                    private Subscription subscription;

                    @Override
                    public void onSubscribe(Subscription subscription) {
                        this.startTime = System.currentTimeMillis();
                        this.subscription = subscription;
                        this.subscription.request(Integer.MAX_VALUE);
                    }

                    @Override
                    public void onNext(Long aLong) {
                        if (System.currentTimeMillis() - startTime > 300L) {
                            System.out.println("구독 해지");
                            subscription.cancel();
                            return;
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        System.out.println("에러: " + t);
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("완료");
                    }
                });

        Thread.sleep(1000L);
    }
}
