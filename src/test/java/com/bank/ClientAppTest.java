package com.bank;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.PrintStream;

public class ClientAppTest {

    private PrintStream out;
    private ClientApp app;

    @Before
    public void setUp() {
        out = Mockito.mock(PrintStream.class);
        app = new ClientApp();

        System.setOut(out);
    }

    @Test
    public void shouldPrintRecordsCorrectly_whenMainMethodCalled() {
        String[] emptyArgs = new String[]{};

        app.main(emptyArgs);

        Mockito.verify(out, Mockito.times(100)).println(Mockito.anyString());
    }
}