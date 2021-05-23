package com.js.rxjava.chapter5;

import com.js.rxjava.DebugSubscriber;
import io.reactivex.processors.AsyncProcessor;

public class L05_AsyncProcessorSample {

    public static void main(String[] args) {
        AsyncProcessor<Integer> processor = AsyncProcessor.create();

        processor.subscribe(new DebugSubscriber<>("No.1"));

        processor.onNext(1);
        processor.onNext(2);
        processor.onNext(3);

        System.out.println("Subscriber No.2 추가");
        processor.subscribe(new DebugSubscriber<>("--- No.2"));

        processor.onNext(4);
        processor.onNext(5);

        processor.onComplete();

        System.out.println("Subscriber No.3 추가");
        processor.subscribe(new DebugSubscriber<>("------ No.3"));
    }
}
