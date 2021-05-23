package com.js.rxjava.chapter6;

public class Counter {

    private volatile int count;

    public void increment() {
        count++;
    }

    public int get() {
        return count;
    }
}
