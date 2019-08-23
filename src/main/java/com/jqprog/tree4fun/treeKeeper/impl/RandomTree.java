package com.jqprog.tree4fun.treeKeeper.impl;


import com.jqprog.tree4fun.PrintableTree;
import com.jqprog.tree4fun.treeKeeper.TreeKeeper;

import java.util.*;

public class RandomTree implements TreeKeeper<Integer> {

    private static int nodeUid = 0;

    private final int maxLevel;
    private final Random chaos;
    private final SomeTree root;
    private final int maxValueInTree;


    public RandomTree(int maxLevel, int rootValue, int maxValueInTree) {
        this.maxLevel = maxLevel;
        this.maxValueInTree = maxValueInTree;
        this.root = new SomeTree(rootValue);
        this.chaos = new Random();
    }

    public SomeTree getRoot() {
        return this.root;
    }

    public void createTree() {
        int currentSize = 1;
        createRecursive(root, currentSize);
    }


    private void createRecursive(SomeTree tree, int currentLevel) {
        if (currentLevel > maxLevel) {
            return;
        }
        currentLevel++;

        if (shouldGenerateNode()) {
            SomeTree left = new SomeTree(chaos.nextInt(maxValueInTree));
            tree.setLeft(left);
            createRecursive(left, currentLevel);
        }

        if (shouldGenerateNode()) {
            SomeTree right = new SomeTree(chaos.nextInt(maxValueInTree));
            tree.setRight(right);
            createRecursive(right, currentLevel);
        }
    }

    private boolean shouldGenerateNode() {
        int maxRisk = 1;
        int treeBalance = 5;// the higher, the more balanced tree
        int risk = chaos.nextInt(maxRisk);
        int result = chaos.nextInt(treeBalance);
        return result > risk;
    }

    public class SomeTree implements PrintableTree<Integer> {
        private int value;
        private SomeTree left;
        private SomeTree right;

        private SomeTree() {
            this.value = ++nodeUid;
        }

        private SomeTree(int value, SomeTree left, SomeTree right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        private SomeTree(int value) {
            this.value = value;
        }

        @Override
        public Integer getValue() {
            return value;
        }

        public SomeTree getLeft() {
            return left;
        }

        private void setLeft(SomeTree left) {
            this.left = left;
        }

        public SomeTree getRight() {
            return right;
        }

        private void setRight(SomeTree right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return "SomeTree{" +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
