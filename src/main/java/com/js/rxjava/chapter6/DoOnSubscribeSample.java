package com.js.rxjava.chapter6;

import io.reactivex.Flowable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class DoOnSubscribeSample {

    public static void main(String[] args) {
        Flowable.range(1, 5)
                .doOnSubscribe(subscription -> System.out.println("doOnSubscribe"))
                .subscribe(new Subscriber<>() {
                    @Override
                    public void onSubscribe(Subscription subscription) {
                        System.out.println("--- Subscriber: onSubscribe");
                        subscription.request(Integer.MAX_VALUE);
                    }

                    @Override
                    public void onNext(Integer data) {
                        System.out.println("--- Subscriber: onNext: " + data);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
