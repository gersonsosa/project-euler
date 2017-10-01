package com.gersonsosa.projecteuler;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class MaxHeapTest {
    @Test
    public void shouldPollElementsInOrder() throws Exception {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.add(69);
        maxHeap.add(100);
        maxHeap.add(12);
        maxHeap.add(120);
        maxHeap.add(200);

        Assertions.assertThat(maxHeap.poll()).isEqualTo(200);
        Assertions.assertThat(maxHeap.poll()).isEqualTo(120);
        Assertions.assertThat(maxHeap.poll()).isEqualTo(100);
        Assertions.assertThat(maxHeap.poll()).isEqualTo(69);
        Assertions.assertThat(maxHeap.poll()).isEqualTo(12);
    }
}