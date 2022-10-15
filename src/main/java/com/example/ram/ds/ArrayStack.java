package com.example.ram.ds;

import java.lang.reflect.Array;

public class ArrayStack<E> implements Stack<E> {

    private E[] elements;
    private int currentIndex;

    public ArrayStack(E[] e) {
        this.elements = e;
    }

    public ArrayStack(Class<E> clazz, int capacity) {
        this.elements = (E[]) Array.newInstance(clazz, capacity);
        this.currentIndex = -1;
        ;
    }

    @Override
    public void push(E element) {
        currentIndex++;
        this.elements[currentIndex] = element;
    }

    @Override
    public E pop() {
        E element = this.elements[currentIndex];
        currentIndex--;
        return element;
    }

    @Override
    public boolean isEmpty() {
        return this.currentIndex == -1;
    }

    @Override
    public int size() {
        return currentIndex + 1;
    }

    @Override
    public E peek() {
        return this.elements[this.currentIndex];
    }
}
