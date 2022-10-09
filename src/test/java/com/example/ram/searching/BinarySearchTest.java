package com.example.ram.searching;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    @Test
    void findElementIndex() {

        BinarySearch binarySearch = new BinarySearch();
        int elementIndex = binarySearch.findElementIndex(10, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10}, true);
        System.out.println("Element found at " + elementIndex);

    }

    @Test
    void findElementIndexRange() {

        BinarySearch binarySearch = new BinarySearch();
        int[] range = binarySearch.findElementIndexRange(10, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10});
        System.out.println("Element found at " + range[0] + ", " + range[1]);

    }
}