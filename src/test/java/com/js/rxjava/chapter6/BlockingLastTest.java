package com.js.rxjava.chapter6;

import io.reactivex.Flowable;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class BlockingLastTest {

    @Test
    void 마지막통지데이터얻기() {
        long actual = Flowable.interval(300L, TimeUnit.MILLISECONDS)
                .take(3)
                .blockingLast();

        assertThat(actual).isEqualTo(2L);
    }
}
