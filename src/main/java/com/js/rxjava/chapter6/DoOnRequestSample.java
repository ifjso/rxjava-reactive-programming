package com.js.rxjava.chapter6;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class DoOnRequestSample {

    public static void main(String[] args) throws InterruptedException {
        Flowable.range(1, 3)
                .doOnRequest(size -> System.out.println("기존 데이터: size=" + size))
                .observeOn(Schedulers.computation())
                .doOnRequest(size -> System.out.println("--- observeOn 적용 후: size=" + size))
                .subscribe(new Subscriber<>() {

                    private Subscription subscription;

                    @Override
                    public void onSubscribe(Subscription subscription) {
                        this.subscription = subscription;
                        this.subscription.request(1);
                    }

                    @Override
                    public void onNext(Integer data) {
                        System.out.println(data);
                        subscription.request(1);
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

        Thread.sleep(500L);
    }
}
