package com.js.rxjava.chapter6;

import io.reactivex.Flowable;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BlockingIterableTest {

    @Test
    void 통지데이터를얻는Iterable가져오기() throws InterruptedException {
        Iterable<Long> result = Flowable.interval(300L, TimeUnit.MILLISECONDS)
                .take(5)
                .blockingIterable();

        Iterator<Long> iterator = result.iterator();

        assertTrue(iterator.hasNext());

        assertThat(iterator.next()).isEqualTo(0L);
        assertThat(iterator.next()).isEqualTo(1L);
        assertThat(iterator.next()).isEqualTo(2L);

        Thread.sleep(1000L);

        assertThat(iterator.next()).isEqualTo(3L);
        assertThat(iterator.next()).isEqualTo(4L);

        assertFalse(iterator.hasNext());
    }
}
