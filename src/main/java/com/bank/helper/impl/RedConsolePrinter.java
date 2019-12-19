package com.bank.helper.impl;

import com.bank.helper.ConsolePrinter;

import static com.bank.utils.Constants.ANSI_RED;
import static com.bank.utils.Constants.ANSI_RESET;
import static java.lang.System.out;

/**
 * Responsible to print Red coloured outputs.
 */
public class RedConsolePrinter implements ConsolePrinter {

    @Override
    public void println(int i) {
        out.println(ANSI_RED + i + ANSI_RESET);
    }

    @Override
    public void println(String i) {
        out.println(ANSI_RED + i + ANSI_RESET);
    }
}