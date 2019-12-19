package com.bank.handler;

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