package com.bank.handler;

import com.bank.helper.impl.CommandInvoker;
import com.bank.service.ServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FizzHandlerTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Mock
    private ServiceImpl mockedService;

    @Mock
    private CommandInvoker mockedCommandInvoker;

    private FizzHandler handler;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        handler = new FizzHandler(mockedService, mockedCommandInvoker);
    }

    @Test
    public void shouldReturnTrue_whenRelevantParameterPassed() {
        Mockito.when(mockedService.isFizz(Mockito.anyInt())).thenReturn(true);
        Mockito.doNothing().when(mockedCommandInvoker).execute(Mockito.anyInt());

        boolean actual = handler.execute(Mockito.anyInt());

        Mockito.verify(mockedService, Mockito.times(1)).isFizz(Mockito.anyInt());
        Mockito.verify(mockedCommandInvoker, Mockito.times(1)).execute(Mockito.anyString());
        Mockito.verifyNoMoreInteractions(mockedService);
        Mockito.verifyNoMoreInteractions(mockedCommandInvoker);

        Assertions.assertThat(actual).isTrue();
    }

    @Test
    public void shouldReturnFalse_whenIrrelevantParameterPassed() {
        Mockito.when(mockedService.isFizz(Mockito.anyInt())).thenReturn(false);

        boolean actual = handler.execute(Mockito.anyInt());

        Mockito.verify(mockedService, Mockito.times(1)).isFizz(Mockito.anyInt());
        Mockito.verifyNoMoreInteractions(mockedService);
        Mockito.verifyZeroInteractions(mockedCommandInvoker);

        Assertions.assertThat(actual).isFalse();
    }

    @Test
    public void shouldThrowIllegalStateException_whenInvalidParameterPassed() {
        String errorMessage = "Something went wrong!";

        expectedException.expect(IllegalStateException.class);
        expectedException.expectMessage(errorMessage);

        Mockito.when(mockedService.isFizz(Mockito.anyInt())).thenReturn(true);
        Mockito.doThrow(new IllegalStateException(errorMessage)).when(mockedCommandInvoker).execute(Mockito.anyString());

        handler.execute(Mockito.anyInt());
    }
}
