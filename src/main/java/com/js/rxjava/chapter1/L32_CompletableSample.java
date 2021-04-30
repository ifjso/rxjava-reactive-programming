package com.js.rxjava.chapter1;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class L32_CompletableSample {
    public static void main(String[] args) throws InterruptedException {
        Completable completable = Completable.create(emitter -> {
            emitter.onComplete();
        });

        completable
                .subscribeOn(Schedulers.computation())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onComplete() {
                        System.out.println("완료");
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        System.out.println("에러=" + e);
                    }
                });

        Thread.sleep(100L);
    }
}
