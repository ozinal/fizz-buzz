package com.bank.helper.impl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.PrintStream;

public class RedConsolePrinterTest {

    private PrintStream out;
    private RedConsolePrinter printer;

    @Before
    public void setUp() {
        out = Mockito.mock(PrintStream.class);
        printer = new RedConsolePrinter();

        System.setOut(out);
    }

    @Test
    public void shouldPrint_whenNumericParameterPassed() {
        printer.println(6);

        Mockito.verify(out, Mockito.times(1)).println(Mockito.anyString());
    }

    @Test
    public void shouldPrint_whenAlphanumericParameterPassed() {
        printer.println("Buzz");

        Mockito.verify(out, Mockito.times(1)).println(Mockito.anyString());
    }
}
