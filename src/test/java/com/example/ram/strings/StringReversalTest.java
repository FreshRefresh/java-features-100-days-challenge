package com.example.ram.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringReversalTest {

    @Test
    void countWords() {

        StringReversal stringReversal = new StringReversal();
        int cont = stringReversal.countWords("one two three four");
        Assertions.assertEquals(4, cont);
    }

}