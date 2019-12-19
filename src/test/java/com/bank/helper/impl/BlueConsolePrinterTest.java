package com.bank.helper.impl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.PrintStream;

public class BlueConsolePrinterTest {

    private PrintStream out;
    private BlueConsolePrinter printer;

    @Before
    public void setUp() {
        out = Mockito.mock(PrintStream.class);
        printer = new BlueConsolePrinter();

        System.setOut(out);
    }

    @Test
    public void shouldPrint_whenNumericParameterPassed() {
        printer.println(5);

        Mockito.verify(out, Mockito.times(1)).println(Mockito.anyString());
    }
}