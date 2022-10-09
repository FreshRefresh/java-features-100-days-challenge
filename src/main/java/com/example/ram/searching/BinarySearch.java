package com.example.ram.searching;

public class BinarySearch {

    public int findElementIndex(int element, int inputArray[], boolean isFistOccurrence) {

        if (inputArray == null || inputArray.length <= 0) {
            return -1;
        }
        int startIndex = 0;
        int endIndex = inputArray.length - 1;
        int elementAt = -1;

        while (startIndex <= endIndex) {
            int midIndex = (startIndex + endIndex) / 2;
            if (inputArray[midIndex] == element) {
                elementAt = midIndex;
                if (isFistOccurrence) {
                    endIndex = midIndex - 1;
                } else {
                    startIndex = midIndex + 1;
                }
            } else if (element < inputArray[midIndex]) {
                endIndex = midIndex - 1;
            } else {
                startIndex = midIndex + 1;
            }
        }
        return elementAt;
    }

    public int[] findElementIndexRange(int element, int inputArray[]) {

        int firstOccurrence = findElementIndex(element, inputArray, true);
        int lastOccurrence = findElementIndex(element, inputArray, false);


        return new int[]{firstOccurrence, lastOccurrence};
    }
}
