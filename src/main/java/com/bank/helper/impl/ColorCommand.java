package com.bank.helper.impl;

import com.bank.helper.Command;
import com.bank.helper.ConsolePrinter;

/**
 * Takes ConsolePrinter implementation for overloaded execute method.
 */
public class ColorCommand implements Command {

    private ConsolePrinter consolePrinter;

    public ColorCommand(ConsolePrinter printer) {
        this.consolePrinter = printer;
    }
}