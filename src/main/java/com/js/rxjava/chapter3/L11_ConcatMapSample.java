package com.js.rxjava.chapter3;

import io.reactivex.Flowable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class L11_ConcatMapSample {
    public static void main(String[] args) throws InterruptedException {
        Flowable<String> flowable = Flowable.just("A", "B", "C", "D", "E", "F", "G", "H", "I", "J")
                .concatMap(data -> Flowable.just(data).delay(1000L, TimeUnit.MILLISECONDS));

        flowable.subscribe(data -> {
            String threadName = Thread.currentThread().getName();
            String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("ss.SSS"));
            System.out.println(threadName + ": data=" + data + ", time=" + time);
        });

        Thread.sleep(11000L);
    }
}
