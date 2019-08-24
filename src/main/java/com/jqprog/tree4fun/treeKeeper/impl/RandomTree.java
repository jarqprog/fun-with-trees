package com.jqprog.tree4fun.treeKeeper.impl;


import com.jqprog.tree4fun.PrintableTree;
import com.jqprog.tree4fun.treeKeeper.TreeKeeper;

import java.util.*;

public class RandomTree implements TreeKeeper<Integer> {

    private final int maxLevel;
    private final Random chaos = new Random();
    private final PrintableTree<Integer> root;
    private final int maxValueInTree;
    private final int balanceFactor;


    public static RandomTreeBuilder builder() {
        return new RandomTreeBuilder();
    }

    private RandomTree(int maxLevel, PrintableTree<Integer> root, int maxValueInTree, int balanceFactor) {
        this.maxLevel = maxLevel;
        this.root = root;
        this.maxValueInTree = maxValueInTree;
        this.balanceFactor = balanceFactor;
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
        int risk = chaos.nextInt(maxRisk);
        int result = chaos.nextInt(balanceFactor);
        return result > risk;
    }


    /**
     * builder
     */
    public static class RandomTreeBuilder {
        private final static int minimalBalanceFactor = 5;
        private int maxLevel = 5;
        private int maxValueInTree = 9;
        private int rootValue = 1;
        private int balanceFactor = 20;

        public RandomTreeBuilder addMaxTreeLevel(int maxLevel) {
            final short minimalMaxTreeLevel = 2;
            if (maxLevel < minimalMaxTreeLevel) {
                throw new IllegalArgumentException("Max tree level must be greater than: " + minimalMaxTreeLevel);
            }
            this.maxLevel = maxLevel;
            return this;
        }

        public RandomTreeBuilder addMaxValueInTree(int maxValueInTree) {
            final short minimalMaxValueInTree = 5;
            if (maxValueInTree < minimalMaxValueInTree) {
                throw new IllegalArgumentException("Max value in tree must be greater than: " + minimalMaxValueInTree);
            }
            this.maxValueInTree = maxValueInTree;
            return this;
        }

        public RandomTreeBuilder addRootValue(int rootValue) {
            this.rootValue = rootValue;
            return this;
        }

        public RandomTreeBuilder addBalanceFactor(int balanceFactor) {
            if (balanceFactor < minimalBalanceFactor) {
                throw new IllegalArgumentException("Balance factor must be greater than: " + minimalBalanceFactor +
                        ". The greater factor, your tree is more balanced (recommended value = 20)");
            }
            this.balanceFactor = balanceFactor;
            return this;
        }

        public TreeKeeper<Integer> build() {
            return new RandomTree(maxLevel, new SomeTree(rootValue), maxValueInTree, balanceFactor);
        }
    }




    public static class SomeTree implements PrintableTree<Integer> {
        private int value;
        private PrintableTree<Integer> left;
        private PrintableTree<Integer> right;

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
