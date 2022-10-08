package com.example.ram.sorting;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BubbleSortTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void sort() {
        int inputArray[] = {2, 4, 1, 5, 9, 6};
        int expected[] = {1, 2, 4, 5, 6, 9};

        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(inputArray);

        Assertions.assertArrayEquals(expected, inputArray);
    }
}