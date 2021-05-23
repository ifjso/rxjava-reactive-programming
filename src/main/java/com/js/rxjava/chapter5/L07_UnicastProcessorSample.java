package com.js.rxjava.chapter5;

import com.js.rxjava.DebugSubscriber;
import io.reactivex.processors.UnicastProcessor;

public class L07_UnicastProcessorSample {

    public static void main(String[] args) {
        UnicastProcessor<Integer> processor = UnicastProcessor.create();

        processor.onNext(1);
        processor.onNext(2);

        System.out.println("Subscriber No.1 추가");
        processor.subscribe(new DebugSubscriber<>("No.1"));

        System.out.println("Subscriber No.2 추가");
        processor.subscribe(new DebugSubscriber<>("--- No.2"));

        processor.onNext(3);

        processor.onComplete();
    }
}
