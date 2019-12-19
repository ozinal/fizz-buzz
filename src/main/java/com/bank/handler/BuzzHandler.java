package com.bank.handler;

import com.bank.helper.impl.CommandInvoker;
import com.bank.service.Service;

import static com.bank.utils.Constants.BUZZ;

/**
 * Implements Buzz handler logic and receives service implementation for Buzz
 * logic, it also takes invoker implementation to execute relevant task.
 *
 */
public class BuzzHandler extends AbstractHandler {

    private Service service;
    private CommandInvoker commandInvoker;

    public BuzzHandler(Service service, CommandInvoker invoker) {
        this.service = service;
        this.commandInvoker = invoker;
    }

    /**
     * Responsible to compare service outcome and execute invokers implementation.
     *
     * @param i
     * @return
     */
    @Override
    protected boolean execute(int i) {
        if(service.isBuzz(i)) {
            this.commandInvoker.execute(BUZZ);
            return true;
        }
        return false;
    }
}