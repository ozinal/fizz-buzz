package com.bank.handler;

/**
 * Defines the signature of handlers without having impelementation of execute() method
 * and receives the number of handler implementations with setNext(customHandler);
 *
 * Expose applyTo method to receive number of inputs and progress those inputs with
 * related handlers / service implementations.
 *
 */
public abstract class AbstractHandler {

    private AbstractHandler next;

    public void applyTo(int i) {
        if(!execute(i) && next != null) {
            next.applyTo(i);
        }
    }

    public AbstractHandler setNext(AbstractHandler next) {
        this.next = next;
        return next;
    }

    abstract protected boolean execute(int i);
}