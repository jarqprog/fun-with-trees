package com.jqprog.tree4fun;


import com.jqprog.tree4fun.heightFinder.HeightFinder;
import com.jqprog.tree4fun.heightFinder.impl.SimpleHeightFinder;
import com.jqprog.tree4fun.printer.Printer;
import com.jqprog.tree4fun.printer.TreePrinter;
import com.jqprog.tree4fun.printer.impl.TerminalPrinter;
import com.jqprog.tree4fun.printer.impl.TerminalTreePrinter;
import com.jqprog.tree4fun.treeKeeper.TreeKeeper;
import com.jqprog.tree4fun.treeKeeper.impl.RandomTree;

import java.util.Scanner;

public class App {

    private final static Printer printer = new TerminalPrinter();
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        showIntro();

        printer.printText("Creating tree with random tree keeper...");
        pause();

        TreePrinter treePrinter = TerminalTreePrinter.getInstance();

        TreeKeeper<Integer> randomKeeper = RandomTree
                .builder()
                .addMaxTreeHeight(6)
                .addMaxValueInTree(9)
                .addRootValue(1)
                .addBalanceFactor(10)
                .build();

        randomKeeper.createTree();
        treePrinter.print(randomKeeper.getRoot());

        pause();



        HeightFinder heightFinder = SimpleHeightFinder.getInstance();

        int height = heightFinder.find(randomKeeper.getRoot());

        printer.printText("height of the tree is: " + height);


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
