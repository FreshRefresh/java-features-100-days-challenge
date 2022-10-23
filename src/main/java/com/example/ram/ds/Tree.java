package com.example.ram.ds;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class Tree<T extends Comparable<T>> {

    private Node<T> root;

    public Tree() {
    }

    private void add(T data) {
        Node<T> node = Node.<T>builder().data(data).build();
        if (this.root == null) {
            this.root = node;
        }
    }

    @Builder
    @Getter
    @Setter
    private static class Node<T extends Comparable<T>> {
        private T data;
        private Node<T> left;
        private Node<T> right;
    }
}
