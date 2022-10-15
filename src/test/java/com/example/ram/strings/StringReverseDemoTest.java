package com.example.ram.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringReverseDemoTest {

    @Test
    void helper() {
        String name = "Ram Mittala";
        int i = 0;
        int j = name.length() - 1;
        char str[] = name.toCharArray();

        StringReverseDemo stringReverseDemo = new StringReverseDemo();
        System.out.println("Original String - " + String.valueOf(str));

        stringReverseDemo.helper(str, i, j);
        System.out.println("Reversed String - " + String.valueOf(str));

        Assertions.assertEquals("alattiM maR", String.valueOf(str));
    }
}