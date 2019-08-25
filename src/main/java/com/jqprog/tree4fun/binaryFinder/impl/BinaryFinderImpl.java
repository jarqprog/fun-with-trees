package com.jqprog.tree4fun.binaryFinder.impl;

import com.jqprog.tree4fun.PrintableTree;
import com.jqprog.tree4fun.binaryFinder.BinaryFinder;
import com.jqprog.tree4fun.treeKeeper.BinaryTree;

public class BinaryFinderImpl implements BinaryFinder {

    public static BinaryFinder getInstance() {
        return new BinaryFinderImpl();
    }

    private BinaryFinderImpl() {
    }

    @Override
    public boolean contains(BinaryTree binaryTree, int number) {

        PrintableTree<Integer> root = binaryTree.getRoot();
        int value;

        while (root != null) {
            value = root.getValue();

            if (value == number) {
                return true;
            }

            if (value > number) {
                root = root.getLeft();
            }

            else {
                root = root.getRight();
            }
        }
        return false;
    }
}
