package com.example.ram.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StringReverseDemoTest {

    @Test
    void helper() {
        String name = "Ram Mittala";
        int i = 0;
        int j = name.length() - 1;
        char str[] = name.toCharArray();

        StringReversal stringReversal = new StringReversal();
        System.out.println("Original String - " + String.valueOf(str));

        stringReversal.helper(str, i, j);
        System.out.println("Reversed String - " + String.valueOf(str));

        Assertions.assertEquals("alattiM maR", String.valueOf(str));
    }
}