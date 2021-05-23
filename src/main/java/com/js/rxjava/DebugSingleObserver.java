package com.js.rxjava;

import io.reactivex.SingleObserver;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class DebugSingleObserver<T> implements SingleObserver<T> {

    private String label;

    public DebugSingleObserver() {
        super();
    }

    public DebugSingleObserver(String label) {
        super();
        this.label = label;
    }

    @Override
    public void onSubscribe(@NonNull Disposable disposable) {
    }

    @Override
    public void onSuccess(@NonNull T data) {
        String threadName = Thread.currentThread().getName();
        if (label == null) {
            System.out.println(threadName + ": " + data);
        } else {
            System.out.println(threadName + ": " + label + ": " + data);
        }
    }

    @Override
    public void onError(Throwable throwable) {
        String threadName = Thread.currentThread().getName();
        if (label == null) {
            System.out.println(threadName + ": 에러 = " + throwable);
        } else {
            System.out.println(threadName + ": " + label + ": 에러 = " + throwable);
        }
    }
}
