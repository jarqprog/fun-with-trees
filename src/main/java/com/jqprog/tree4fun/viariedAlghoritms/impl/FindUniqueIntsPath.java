package com.jqprog.tree4fun.viariedAlghoritms.impl;


import com.jqprog.tree4fun.PrintableTree;
import com.jqprog.tree4fun.treeKeeper.TreeKeeper;

import com.jqprog.tree4fun.viariedAlghoritms.FindUniquePath;

import java.util.*;

public class FindUniqueIntsPath implements FindUniquePath<Integer> {

    private static final int PATH_BORDER = -1;
    public static FindUniquePath<Integer> getInstance() {
        return new FindUniqueIntsPath();
    }

    private FindUniqueIntsPath() {
    }


    @Override
    public int find(TreeKeeper<Integer> tree) {
        if (tree == null) {
            return 0;
        }
        List<Integer> paths = new ArrayList<>();
        List<Integer> path = new LinkedList<>();
        findAllPaths(tree.getRoot(), path, paths);
        return getUniqueLongestPath(paths);
    }

    private void findAllPaths(PrintableTree<Integer> node, List<Integer> path, List<Integer> paths) {
        if (node == null) {
            return;
        }
        path.add(node.getValue());
        if (node.getLeft() == null && node.getRight() == null) {
            if (!paths.isEmpty()) {
                paths.add(PATH_BORDER);
            }
            paths.addAll(path);
        }
        findAllPaths(node.getLeft(),  path, paths);
        findAllPaths(node.getRight(), path, paths);
        path.remove(path.size() - 1);
    }

    private int getUniqueLongestPath(List<Integer> paths) {
        Set<Integer> uniquePath = new HashSet<>();
        int longestPath = 0;

        for (Integer num : paths) {
            if (num == PATH_BORDER || uniquePath.contains(num)) {
                if (longestPath < uniquePath.size()) {
                    longestPath = uniquePath.size();
                }
                uniquePath.clear();
            }
            else {
                uniquePath.add(num);
            }
        }
        return longestPath;
    }
}
