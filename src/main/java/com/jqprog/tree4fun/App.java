package com.jqprog.tree4fun;


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

        TreePrinter printer = TerminalTreePrinter.getInstance();

        TreeKeeper<Integer> randomKeeper = RandomTree
                .builder()
                .addMaxTreeLevel(6)
                .addMaxValueInTree(9)
                .addRootValue(1)
                .addBalanceFactor(10)
                .build();

        randomKeeper.createTree();
        printer.print(randomKeeper.getRoot());

        pause();
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
