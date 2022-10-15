package com.example.ram.ds;

public class MyStackDemo {

    public static void main(String[] args) {
        Stack<Integer> stringStack = new ArrayStack<>(Integer.class, 10);

        stringStack.push(10);
        stringStack.push(30);
        stringStack.push(40);
        stringStack.push(50);

        System.out.println(" Peek - " + stringStack.peek());
    }
}
