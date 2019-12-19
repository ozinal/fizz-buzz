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
public class CommandInvokerTest {


    @Mock
    private ColorCommand mockedCommand;

    @InjectMocks
    private CommandInvoker invoker;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldExecuteColorCommand_whenNumbericParameterPassed() {
        invoker.execute(8);

        Mockito.verify(mockedCommand, Mockito.times(1)).execute(Mockito.anyInt());
    }

    @Test
    public void shouldExecuteColorCommand_whenAlphanumericParameterPassed() {
        invoker.execute("Buzz");

        Mockito.verify(mockedCommand, Mockito.times(1)).execute(Mockito.anyString());
    }
}