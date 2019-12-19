package com.bank.helper.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ColorCommandTest {

    @Mock
    private BlueConsolePrinter mockedConsolePrinter;

    @InjectMocks
    private ColorCommand command;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldExecuteConsolePrinter_whenNumericParameterPassed() {
        Mockito.doNothing().when(mockedConsolePrinter).println(Mockito.anyInt());

        command.execute(7);

        Mockito.verify(mockedConsolePrinter, Mockito.times(1)).println(Mockito.anyInt());
    }

    @Test
    public void shouldExecuteConsolePrinter_whenAlphanumericParameterPassed() {
        Mockito.doNothing().when(mockedConsolePrinter).println(Mockito.anyString());

        command.execute("FizzBuzz");

        Mockito.verify(mockedConsolePrinter, Mockito.times(1)).println(Mockito.anyString());
    }

}