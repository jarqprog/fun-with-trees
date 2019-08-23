package com.jqprog.tree4fun;

public interface PrintableTree<T extends Comparable> {

    T getValue();
    PrintableTree<T> getLeft();
    PrintableTree<T> getRight();
}
