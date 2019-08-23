package com.jqprog.tree4fun.treeKeeper;

import com.jqprog.tree4fun.PrintableTree;

public interface TreeKeeper<T extends Comparable> {

    PrintableTree<T> getRoot();
    void createTree();

}
