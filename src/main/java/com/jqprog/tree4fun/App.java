package com.jqprog.tree4fun;


import com.jqprog.tree4fun.binaryFinder.BinaryFinder;
import com.jqprog.tree4fun.binaryFinder.impl.BinaryFinderImpl;
import com.jqprog.tree4fun.binarySort.BinarySort;
import com.jqprog.tree4fun.binarySort.impl.BinarySortImpl;
import com.jqprog.tree4fun.heightFinder.HeightFinder;
import com.jqprog.tree4fun.heightFinder.impl.SimpleHeightFinder;
import com.jqprog.tree4fun.printer.Printer;
import com.jqprog.tree4fun.printer.TreePrinter;
import com.jqprog.tree4fun.printer.impl.TerminalPrinter;
import com.jqprog.tree4fun.printer.impl.TerminalTreePrinter;
import com.jqprog.tree4fun.treeKeeper.BinaryTree;
import com.jqprog.tree4fun.treeKeeper.TreeKeeper;
import com.jqprog.tree4fun.treeKeeper.impl.BinaryTreeImpl;
import com.jqprog.tree4fun.treeKeeper.impl.RandomTree;
import com.jqprog.tree4fun.viariedAlghoritms.FindUniquePath;
import com.jqprog.tree4fun.viariedAlghoritms.impl.FindUniqueIntsPath;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class App {

    private final static Printer printer = new TerminalPrinter();
    private final static Logger logger = Logger.getLogger(App.class.getSimpleName());
    private final static Scanner scanner = new Scanner(System.in);
    private final static TreePrinter treePrinter = TerminalTreePrinter.getInstance();
    private final static HeightFinder heightFinder = SimpleHeightFinder.getInstance();

    public static void main(String[] args) {

        showIntro();

//        int[] binaryTreeData = {-2, 3, 1, 0, 7, 9, 2, -5, -4, 3, 4, 5, 1, 2, -9, -4, 8, 5, 6, -5, 3, -20, -18, -15};
        int[] binaryTreeData = {1,1, 1, 2, 3, 9, 7, 3, 3, 2, 1, 0, 3, 8, 4, 3};
        printer.printText("Creating binary tree with data: " + Arrays.toString(binaryTreeData));
//        pause();

        TreeKeeper<Integer> binaryTreeKeeper =  BinaryTreeImpl.getInstance(binaryTreeData);
        binaryTreeKeeper.createTree();

//        treePrinter.print(binaryTreeKeeper.getRoot());

        //height
        int height = heightFinder.find(binaryTreeKeeper.getRoot());
        printer.printText("height of the tree is: " + height);

        //unique path
        FindUniquePath<Integer> uniquePathFinder = FindUniqueIntsPath.getInstance();
//        printer.printText("Find unique path in tree:");
//        int longestPath = uniquePathFinder.find(binaryTreeKeeper);
//        printer.printText("Path: " + longestPath);

//        BinarySort binarySort = BinarySortImpl.getInstance();
//        printer.printText("Use binary tree to sort numbers: " + Arrays.toString(binaryTreeData));
//        List<Integer> sorted = binarySort.sort((BinaryTreeImpl) binaryTreeKeeper);
//        printer.printText("After sort: " + sorted);
////        pause();
//
//        BinaryFinder binaryFinder = BinaryFinderImpl.getInstance();
//        printer.printText("Check if number: " + 5 + " exist in binary tree:");
//        boolean contains5 = binaryFinder.contains((BinaryTree) binaryTreeKeeper, 5);
//        printer.printText("Answer: " + contains5);
//
//        printer.printText("Check if number: " + 15 + " exist in binary tree:");
//        boolean contains15 = binaryFinder.contains((BinaryTree) binaryTreeKeeper, 15);
//        printer.printText("Answer: " + contains15);
//
//
//
//
//        printer.printText("Creating tree with random tree keeper...");
//        pause();
//
//
//
        TreeKeeper<Integer> randomKeeper = RandomTree
                .builder()
                .addMaxTreeHeight(500)
                .addMaxValueInTree(500)
                .addRootValue(1)
                .addBalanceFactor(100)
                .build();

        randomKeeper.createTree();
        treePrinter.print(randomKeeper.getRoot());

//        pause();

//        height = heightFinder.find(randomKeeper.getRoot());
//        printer.printText("height of the tree is: " + height);

        //unique path
//        printer.printText("Find unique path in random tree:");
        int longestPath = uniquePathFinder.find(randomKeeper);
        printer.printText("Path: " + longestPath);


    }

    private static void showIntro() {
        printer.printSpecialEffects();
        printer.printDecoratedText("Welcome to TREE 4 FUN by jq");
        printer.printSpecialEffects();
    }

    private static void pause() {
        printer.printText("Type 'k' and press enter if you are ready -> ");
        scanner.nextLine();
    }

}
