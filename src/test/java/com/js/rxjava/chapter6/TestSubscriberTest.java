package com.js.rxjava.chapter6;

import io.reactivex.Flowable;
import io.reactivex.subscribers.TestSubscriber;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class TestSubscriberTest {

    @Test
    void TestSubscriber사용의간단한예제() throws InterruptedException {
        Flowable<Long> target = Flowable.interval(100L, TimeUnit.MILLISECONDS);

        TestSubscriber<Long> testSubscriber = target.test();

        testSubscriber.assertEmpty();

        testSubscriber.await(150L, TimeUnit.MILLISECONDS);

        testSubscriber.assertValue(0L);

        testSubscriber.await(100L, TimeUnit.MILLISECONDS);

        testSubscriber.assertValues(0L, 1L);
    }

    @Test
    void 빈Flowable테스트() {
        Flowable.empty()
                .test()
                .assertNoValues()
                .assertNoErrors()
                .assertComplete();
    }
}
