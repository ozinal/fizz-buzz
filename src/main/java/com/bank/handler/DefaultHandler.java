package com.bank.handler;

import com.bank.helper.impl.CommandInvoker;
import com.bank.service.Service;


public class DefaultHandler extends AbstractHandler {

    private Service service;
    private CommandInvoker commandInvoker;

    public DefaultHandler(Service service, CommandInvoker invoker) {
        this.service = service;
        this.commandInvoker = invoker;
    }

    @Override
    protected boolean execute(int i) {
        if(!service.isFizz(i) && !service.isBuzz(i)) {
            this.commandInvoker.execute(i);
            return true;
        }
        return false;
    }
}