package com.bank.handler;

import com.bank.helper.impl.CommandInvoker;
import com.bank.service.Service;

import static com.bank.utils.Constants.FIZZ;

/**
 * Implements Fizz handler logic and receives service implementation for Fizz
 * logic, it also takes invoker implementation to execute relevant task.
 *
 */
public class FizzHandler extends AbstractHandler {

    private Service service;
    private CommandInvoker commandInvoker;

    public FizzHandler(Service service, CommandInvoker invoker) {
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
        if(service.isFizz(i)) {
            commandInvoker.execute(FIZZ);
            return true;
        }
        return false;
    }
}