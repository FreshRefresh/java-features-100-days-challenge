package com.example.ram.sorting;

public class BubbleSort implements Sort {

    public static void main(String[] args) {

        BubbleSort app = new BubbleSort();
        int inputArray[] = {15, 2, 9, 5, 16, 10};
        System.out.println("Original Array....");
        app.printArray(inputArray);

        app.sort(inputArray);

        System.out.println("After sorting....");
        app.printArray(inputArray);
    }

    public void sort(int inputArray[]) {
        if (inputArray == null || inputArray.length <= 1) {
            return;
        }
        for (int i = 0; i < inputArray.length - 1; i++) {
            for (int j = 0; j < inputArray.length - i - 1; j++) {
                if (inputArray[j] > inputArray[j + 1]) {
                    int temp = inputArray[j];
                    inputArray[j] = inputArray[j + 1];
                    inputArray[j + 1] = temp;
                }
            }
        }
    }

    public void printArray(int inputArray[]) {
        System.out.println("\n-------------------------");
        for (int i = 0; i < inputArray.length; i++) {
            System.out.printf(" " + inputArray[i]);
        }
        System.out.println("\n-------------------------");
    }
}
