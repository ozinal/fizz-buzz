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
}