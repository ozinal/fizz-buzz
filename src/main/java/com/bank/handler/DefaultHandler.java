package com.bank.handler;

import com.bank.helper.impl.CommandInvoker;
import com.bank.service.Service;

/**
 * Implements Default handler logic and receives service implementation for Default
 * logic (non-Fizz, non-Buzz, non-FizzBuzz)
 * It also takes invoker implementation to execute relevant task.
 *
 */
public class DefaultHandler extends AbstractHandler {

    private Service service;
    private CommandInvoker commandInvoker;

    public DefaultHandler(Service service, CommandInvoker invoker) {
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
        if(!service.isFizz(i) && !service.isBuzz(i)) {
            this.commandInvoker.execute(i);
            return true;
        }
        return false;
    }
}