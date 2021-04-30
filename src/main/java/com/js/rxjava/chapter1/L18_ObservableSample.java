package com.js.rxjava.chapter1;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class L18_ObservableSample {
    public static void main(String[] args) throws InterruptedException {
        Observable<String> observable = Observable.create(emitter -> {
            String[] datas = {"Hello, World!", "안녕, RxJava!"};

            for (String data : datas) {
                if (emitter.isDisposed()) {
                    return;
                }

                emitter.onNext(data);
            }

            emitter.onComplete();
        });

        observable
                .observeOn(Schedulers.computation())
                .subscribe(new Observer<>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable disposable) {

                    }

                    @Override
                    public void onNext(@NonNull String item) {
                        String threadName = Thread.currentThread().getName();
                        System.out.println(threadName + ": " + item);
                    }

                    @Override
                    public void onComplete() {
                        String threadName = Thread.currentThread().getName();
                        System.out.println(threadName + ": 완료");
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        e.printStackTrace();
                    }
                });

        Thread.sleep(500L);
    }
}
