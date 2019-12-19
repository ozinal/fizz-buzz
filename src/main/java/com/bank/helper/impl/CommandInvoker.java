package com.bank.helper.impl;

import com.bank.helper.Command;

/**
 * Responsible to execute implementation of Command interface
 */
public class CommandInvoker {
    private Command command;

    public CommandInvoker(Command c) {
        this.command = c;
    }

    public void execute(int i) {
        this.command.execute(i);
    }

    public void execute(String i) {
        this.command.execute(i);
    }
}