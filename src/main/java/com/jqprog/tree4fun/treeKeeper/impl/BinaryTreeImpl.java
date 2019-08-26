package com.jqprog.tree4fun.treeKeeper.impl;


import com.jqprog.tree4fun.PrintableTree;
import com.jqprog.tree4fun.treeKeeper.BinaryTree;
import com.jqprog.tree4fun.treeKeeper.TreeKeeper;

public class BinaryTreeImpl implements TreeKeeper<Integer>, BinaryTree {

    private static int nodeIdGen = 0;

    public static TreeKeeper<Integer> getInstance(int[] numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("Cannot create binary tree without numbers!");
        }
        return new BinaryTreeImpl(numbers);
    }

    private final PrintableTree<Integer> root;
    private final int[] numbers;


    private BinaryTreeImpl(int[] numbers) {
        this.numbers = numbers;
        this.root = new Tree(numbers[0]);
    }


    @Override
    public void createTree() {

        Tree currentNode;
        int currentValue;

        for (int i = 1; i < numbers.length; i++) {
            currentNode = (Tree) root;

            while (currentNode != null) {
                currentValue = numbers[i];
                if (currentValue <= currentNode.getValue()) {
                    if (currentNode.leftChild == null) {
                        currentNode.leftChild = new Tree(currentValue);
                        break;
                    }
                    else {
                        currentNode = currentNode.leftChild;
                    }
                }
                else {
                    if (currentNode.rightChild == null) {
                        currentNode.rightChild = new Tree(currentValue);
                        break;
                    }
                    else {
                        currentNode = currentNode.rightChild;
                    }
                }
            }
        }
    }

    @Override
    public PrintableTree<Integer> getRoot() {
        return this.root;
    }

    public class Tree implements PrintableTree<Integer> {

        private final int id;
        private int value;
        private Tree leftChild;
        private Tree rightChild;


        public Tree(int value) {
            this.id = ++nodeIdGen;
            this.value = value;
        }


        @Override
        public String toString() {
            return "Tree{value=" + value +
                    '}';
        }

        @Override
        public Integer getValue() {
            return value;
        }

        @Override
        public PrintableTree<Integer> getLeft() {
            return leftChild;
        }

        @Override
        public PrintableTree<Integer> getRight() {
            return rightChild;
        }

        public int getId() {
            return id;
        }
    }
}

