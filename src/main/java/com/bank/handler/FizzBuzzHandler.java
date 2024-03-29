package com.bank.handler;

import com.bank.helper.impl.CommandInvoker;
import com.bank.service.Service;

import static com.bank.utils.Constants.FIZZ_BUZZ;

/**
 * Implements FizzBuzz handler logic and receives service implementation for FizzBuzz
 * logic, it also takes invoker implementation to execute relevant task.
 *
 */
public class FizzBuzzHandler extends AbstractHandler {

    private Service service;
    private CommandInvoker commandInvoker;

    public FizzBuzzHandler(Service service, CommandInvoker invoker) {
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
        if(service.isFizzBuzz(i)) {
            this.commandInvoker.execute(FIZZ_BUZZ);
            return true;
        }
        return false;
    }
}