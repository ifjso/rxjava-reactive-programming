package com.js.rxjava.chapter6;

import io.reactivex.Flowable;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class BlockingFirstTest {

    @Test
    void 첫번째통지데이터얻기() {
        long actual = Flowable.interval(300L, TimeUnit.MILLISECONDS)
                .blockingFirst();

        assertThat(actual).isEqualTo(0L);
    }
}
