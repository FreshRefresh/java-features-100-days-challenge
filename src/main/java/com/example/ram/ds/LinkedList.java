package com.example.ram.ds;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class LinkedList<T> {

    private Node<T> head;
    private Node<T> tail;

    public LinkedList() {
    }

    public void add(T data) {
        Node<T> node = Node.<T>builder().data(data).build();
        if (this.head == null) {
            this.head = node;
        } else {
            this.tail.setNext(node);
        }
        this.tail = node;
    }

    public void print() {
        Node<T> temp = this.head;
        while (temp != null) {
            System.out.printf(" -> " + temp.getData());
            temp = temp.getNext();
        }
        System.out.println(" ");
    }

    public void reverse() {
        Node<T> current = this.head;
        Node<T> previous = null;
        while (current != null) {
            Node<T> next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        this.head = previous;
    }

    @Builder
    @Getter
    @Setter
    private static class Node<T> {
        private T data;
        private Node<T> next;
    }
}
