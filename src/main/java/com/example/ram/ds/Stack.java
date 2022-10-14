package com.example.ram.ds;

public interface Stack<E> {

    void push(E data);

    E pop();

    boolean isEmpty();

    int size();

    E peek();
}
