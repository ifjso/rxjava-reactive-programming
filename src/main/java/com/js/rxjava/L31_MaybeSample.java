package com.js.rxjava;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class L31_MaybeSample {
    public static void main(String[] args) {
        Maybe<DayOfWeek> maybe = Maybe.create(emitter -> {
            emitter.onSuccess(LocalDate.now().getDayOfWeek());
        });

        maybe.subscribe(new MaybeObserver<>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onSuccess(@NonNull DayOfWeek dayOfWeek) {
                System.out.println(dayOfWeek);
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
    }
}
