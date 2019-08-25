package com.jqprog.tree4fun.binarySort.impl;

import com.jqprog.tree4fun.PrintableTree;
import com.jqprog.tree4fun.binarySort.BinarySort;
import com.jqprog.tree4fun.treeKeeper.impl.BinaryTree;

import java.util.LinkedList;
import java.util.List;

public class BinarySortImpl implements BinarySort {

    public static BinarySort getInstance() {
        return new BinarySortImpl();
    }

    private BinarySortImpl() {
    }

    @Override
    public List<Integer> sort(BinaryTree binaryTree) {

        PrintableTree<Integer> root = binaryTree.getRoot();
        List<Integer> sorted = new LinkedList<>();
        sortAscRec(root, sorted);
        return sorted;
    }

    private void sortAscRec(PrintableTree<Integer> node, List<Integer> sorted) {
        if (node == null) {
            return;
        }
        sortAscRec(node.getLeft(), sorted);
        sorted.add(node.getValue());
        sortAscRec(node.getRight(), sorted);
    }
}
