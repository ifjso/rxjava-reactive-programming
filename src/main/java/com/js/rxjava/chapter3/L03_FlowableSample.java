package com.js.rxjava.chapter3;

import io.reactivex.Flowable;

import java.util.Arrays;
import java.util.List;

public class L03_FlowableSample {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c");
        Flowable<String> flowable = Flowable.fromIterable(list);

        flowable.subscribe(data -> System.out.println(data));
    }
}
