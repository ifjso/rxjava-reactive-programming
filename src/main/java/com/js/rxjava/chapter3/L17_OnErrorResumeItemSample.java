package com.js.rxjava.chapter3;

import io.reactivex.Flowable;
import io.reactivex.subscribers.DisposableSubscriber;

public class L17_OnErrorResumeItemSample {
    public static void main(String[] args) {
        Flowable.just(1, 3, 5, 0, 2, 4)
                .map(data -> 100 / data)
                .onErrorReturnItem(0)
                .subscribe(new DisposableSubscriber<>() {
                    @Override
                    public void onNext(Integer data) {
                        System.out.println("data=" + data);
                    }

                    @Override
                    public void onError(Throwable t) {
                        System.out.println("error=" + t);
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("완료");
                    }
                });
    }
}
