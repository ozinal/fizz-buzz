package com.bank.handler;

import com.bank.helper.impl.CommandInvoker;
import com.bank.service.Service;

import static com.bank.utils.Constants.BUZZ;

public class BuzzHandler extends AbstractHandler {

    private Service service;
    private CommandInvoker commandInvoker;

    public BuzzHandler(Service service, CommandInvoker invoker) {
        this.service = service;
        this.commandInvoker = invoker;
    }
}