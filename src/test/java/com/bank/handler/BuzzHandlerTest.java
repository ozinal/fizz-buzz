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
public class BuzzHandlerTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Mock
    private ServiceImpl mockedService;

    @Mock
    private CommandInvoker mockedCommandInvoker;

    private BuzzHandler handler;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        handler = new BuzzHandler(mockedService, mockedCommandInvoker);
    }

    @Test
    public void shouldReturnTrue_whenRelevantParameterPassed() {
        Mockito.when(mockedService.isBuzz(Mockito.anyInt())).thenReturn(true);
        Mockito.doNothing().when(mockedCommandInvoker).execute(Mockito.anyString());

        boolean actual = handler.execute(Mockito.anyInt());

        Mockito.verify(mockedService, Mockito.times(1)).isBuzz(Mockito.anyInt());
        Mockito.verify(mockedCommandInvoker, Mockito.times(1)).execute(Mockito.anyString());
        Mockito.verifyNoMoreInteractions(mockedService);
        Mockito.verifyNoMoreInteractions(mockedCommandInvoker);

        Assertions.assertThat(actual).isTrue();
    }

    @Test
    public void shouldReturnFalse_whenIrrelevantParameterPassed() {
        Mockito.when(mockedService.isBuzz(Mockito.anyInt())).thenReturn(false);
        Mockito.doNothing().when(mockedCommandInvoker).execute(Mockito.anyString());

        boolean actual = handler.execute(Mockito.anyInt());

        Mockito.verify(mockedService, Mockito.times(1)).isBuzz(Mockito.anyInt());
        Mockito.verifyNoMoreInteractions(mockedService);
        Mockito.verifyZeroInteractions(mockedCommandInvoker);

        Assertions.assertThat(actual).isFalse();
    }

    @Test
    public void shouldThrowIllegalArgumentException_whenInvalidParamPassed() {
        String errorMessage = "Something went wrong!";

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(errorMessage);

        Mockito.when(mockedService.isBuzz(Mockito.anyInt())).thenReturn(true);
        Mockito.doThrow(new IllegalArgumentException(errorMessage)).when(mockedCommandInvoker).execute(Mockito.anyString());

        handler.execute(Mockito.anyInt());
    }
}