package com.js.rxjava.chapter6;

import com.js.rxjava.DebugSubscriber;
import io.reactivex.Flowable;

public class DoOnErrorSample {

    public static void main(String[] args) {
        Flowable.range(1, 5)
                .doOnError(error -> System.out.println("기존 데이터: " + error.getMessage()))
                .map(data -> {
                    if (data == 3) {
                        throw new Exception("예외 발생");
                    }

                    return data;
                })
                .doOnError(error -> System.out.println("--- map 적용 후: " + error.getMessage()))
                .subscribe(new DebugSubscriber<>());
    }
}
