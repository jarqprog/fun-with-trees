package com.jqprog.tree4fun.treeKeeper.impl;


import com.jqprog.tree4fun.PrintableTree;
import com.jqprog.tree4fun.treeKeeper.TreeKeeper;

import java.util.*;

public class RandomTree implements TreeKeeper<Integer> {

    private static int nodeUid = 0;

    private final int maxLevel;
    private final Random chaos = new Random();
    private final PrintableTree<Integer> root;
    private final int maxValueInTree;


    public static RandomTreeBuilder builder() {
        return new RandomTreeBuilder();
    }

    private RandomTree(int maxLevel, PrintableTree<Integer> root, int maxValueInTree) {
        this.maxLevel = maxLevel;
        this.root = root;
        this.maxValueInTree = maxValueInTree;
    }

    public PrintableTree<Integer> getRoot() {
        return this.root;
    }

    public void createTree() {
        int currentSize = 1;
        createRecursive((SomeTree) root, currentSize);
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


    /**
     * builder
     */
    public static class RandomTreeBuilder {
        private int maxLevel;
        private int maxValueInTree;
        private int rootValue;

        public RandomTreeBuilder addMaxTreeLevel(int maxLevel) {
            this.maxLevel = maxLevel;
            return this;
        }

        public RandomTreeBuilder addMaxValueInTree(int maxValueInTree) {
            this.maxValueInTree = maxValueInTree;
            return this;
        }

        public RandomTreeBuilder addRootValue(int rootValue) {
            this.rootValue = rootValue;
            return this;
        }

        public TreeKeeper<Integer> build() {
            return new RandomTree(maxLevel, new SomeTree(rootValue), maxValueInTree);
        }
    }




    public static class SomeTree implements PrintableTree<Integer> {
        private int value;
        private PrintableTree<Integer> left;
        private PrintableTree<Integer> right;

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

        public PrintableTree<Integer> getLeft() {
            return left;
        }

        private void setLeft(PrintableTree<Integer> left) {
            this.left = left;
        }

        public PrintableTree<Integer> getRight() {
            return right;
        }

        private void setRight(PrintableTree<Integer> right) {
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
