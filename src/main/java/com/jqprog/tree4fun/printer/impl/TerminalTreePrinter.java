package com.jqprog.tree4fun.printer.impl;

import com.jqprog.tree4fun.PrintableTree;
import com.jqprog.tree4fun.printer.TreePrinter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TerminalTreePrinter implements TreePrinter {

    private final static int MAX_LEVEL_TO_PRINT = 8;

    public static TreePrinter getInstance() {
        return new TerminalTreePrinter();
    }


    private TerminalTreePrinter() {
    }

    @Override
    public void print(PrintableTree root) {
        int maxLevel = maxLevel(root);
        if (maxLevel > MAX_LEVEL_TO_PRINT) {
            throw new RuntimeException("Cannot print tree with height more than " +MAX_LEVEL_TO_PRINT +
                    ", give me smaller tree, please...");
        }
        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private void printNodeInternal(List<PrintableTree> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor +1)) - 1;

        printWhitespaces(firstSpaces);

        List<PrintableTree> newNodes = new ArrayList<>();
        for (PrintableTree node : nodes) {
            if (node != null) {
                System.out.print(node.getValue());
                newNodes.add(node.getLeft());
                newNodes.add(node.getRight());
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            printWhitespaces(betweenSpaces);
        }
        System.out.println();

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).getLeft() != null)
                    System.out.print("/");
                else
                    printWhitespaces(1);

                printWhitespaces(i + i - 1);

                if (nodes.get(j).getRight() != null)
                    System.out.print("\\");
                else
                    printWhitespaces(1);

                printWhitespaces(endgeLines + endgeLines - i);
            }
            System.out.println();
        }
        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private int maxLevel(PrintableTree node) {
        if (node == null)
            return 0;

        return Math.max(maxLevel(node.getLeft()), maxLevel(node.getRight())) + 1;
    }

    private boolean isAllElementsNull(List list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }
        return true;
    }
}
