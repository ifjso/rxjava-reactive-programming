package com.js.rxjava.chapter6;

import io.reactivex.Flowable;
import io.reactivex.subscribers.DisposableSubscriber;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

public class BlockingSubscribeTest {

    @Test
    void Flowable을실행하고처리결과확인() {
        Flowable<Long> flowable = Flowable.interval(100L, TimeUnit.MILLISECONDS)
                .take(5);

        Counter counter = new Counter();

        flowable
                .blockingSubscribe(new DisposableSubscriber<Long>() {
                    @Override
                    public void onNext(Long aLong) {
                        counter.increment();
                    }

                    @Override
                    public void onError(Throwable t) {
                        fail(t.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

        assertThat(counter.get()).isEqualTo(5);
    }
}
