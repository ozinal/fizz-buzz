package com.bank;

import com.bank.handler.*;
import com.bank.helper.ConsolePrinter;
import com.bank.helper.impl.ColorCommand;
import com.bank.helper.impl.CommandInvoker;
import com.bank.service.Service;
import com.bank.service.ServiceImpl;
import com.bank.utils.ConsolePrinterUtil;

/**
 * Application is responsible to print the numbers from 1 to 100. But for multiples of three print "Fizz" instead of
 * the number and for the multiples of five print "Buzz". For numbers which are multiples of both three and five
 * print "FizzBuzz"
 *
 * New requirements added:
 * A Number is Fizz if it is divisible by 3 or if it has a 3 in it
 * A number is Buzz if it is divisible by 5 or if it has a 5 in it
 * A number is FizzBuzz if it satisfy above 2 criteria(s) together.
 */
public class ClientApp {
    public static void main(String[] args) {

        ConsolePrinter cp = ConsolePrinterUtil.getUnderlyingBlueConsolePrinter();
        ColorCommand command = new ColorCommand(cp);
        CommandInvoker invoker = new CommandInvoker(command);

        Service service = new ServiceImpl();

        AbstractHandler handler = new DefaultHandler(service, invoker);
        handler.setNext(new FizzBuzzHandler(service, invoker))
                .setNext(new FizzHandler(service, invoker))
                .setNext(new BuzzHandler(service, invoker));

        for(int i = 1; i < 101; i++) {
            handler.applyTo(i);
        }
    }
}