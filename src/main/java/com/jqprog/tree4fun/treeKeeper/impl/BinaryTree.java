package com.jqprog.tree4fun.treeKeeper.impl;


import com.jqprog.tree4fun.PrintableTree;
import com.jqprog.tree4fun.treeKeeper.TreeKeeper;

public class BinaryTree implements TreeKeeper<Integer> {

    private static int nodeIdGen = 0;

    private PrintableTree<Integer> root;


    public PrintableTree<Integer> createTree(int... values) {



        return null;
    }

    @Override
    public PrintableTree<Integer> getRoot() {
        return null;
    }

    @Override
    public void createTree() {

    }


    public class Tree implements PrintableTree<Integer> {

        private final int id;
        private int value;
        private Tree leftChild;
        private Tree rightChild;


        public Tree(int value) {
            this.id = ++nodeIdGen;
            System.out.println("Node created with id: " + id);
            this.value = value;
        }


        @Override
        public String toString() {
            return "Tree{" +
                    "id=" + id +
                    ", value=" + value +
                    ", leftChild=" + leftChild +
                    ", rightChild=" + rightChild +
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
    }
}

