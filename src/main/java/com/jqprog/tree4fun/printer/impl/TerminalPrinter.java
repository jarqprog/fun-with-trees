package com.jqprog.tree4fun.printer.impl;

import com.jqprog.tree4fun.printer.Printer;

public class TerminalPrinter implements Printer {

    private final static String nextLine = "\n";
    private final static String doubleNextLine = "\n\n";
    private final static String decoration = "\t***\t";
    private final static int linesForFX = 20;
    private final static String fxSymbol = ".";

    @Override
    public void printText(String text) {
        System.out.println(doubleNextLine + text + doubleNextLine);
    }

    @Override
    public void printDecoratedText(String text) {
        System.out.println(doubleNextLine + decoration+ text + decoration + doubleNextLine);

    }

    @Override
    public void printSpecialEffects() {
        int signMultiplier;
        int whitespaceMultiplier = 0;
        int breakingPoint = linesForFX/2;
        for (int i=0; i<=linesForFX; i++) {
            if (i < breakingPoint) {
                signMultiplier = i;
                whitespaceMultiplier = i * i;
            } else {
                signMultiplier = i*i;
                whitespaceMultiplier /= 2;
            }
            String newFxSymbol = new String(new char[signMultiplier]).replace("\0", fxSymbol);
            String fx = new String(new char[whitespaceMultiplier]).replace("\0", " ");
            System.out.println(fx + newFxSymbol);
        }
    }
}
