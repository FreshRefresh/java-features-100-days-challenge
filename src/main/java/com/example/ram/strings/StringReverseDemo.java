package com.example.ram.strings;

public class StringReverseDemo {

    public void helper(char[] str, int i, int j) {

        if (i > j) {
            return;
        }
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
        helper(str, i + 1, j - 1);
    }
}
