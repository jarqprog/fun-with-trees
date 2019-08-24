package com.jqprog.tree4fun.heightFinder.impl;

import com.jqprog.tree4fun.PrintableTree;
import com.jqprog.tree4fun.heightFinder.HeightFinder;

public class SimpleHeightFinder implements HeightFinder {


    public static HeightFinder getInstance() {
        return new SimpleHeightFinder();
    }

    private SimpleHeightFinder () {}

    @Override
    public int find(PrintableTree root) {

        return findRec(root, 0);
    }

    private int findRec(PrintableTree root, int height) {

        System.out.println(root);
        System.out.println(height);
        if (root == null) {
            return height;
        }

        int heightLeft = findRec(root.getLeft(), height+1);
        int heightRight = findRec(root.getRight(), height+1);
        height = heightLeft > heightRight ? heightLeft : heightRight;
        return height;
    }
}
