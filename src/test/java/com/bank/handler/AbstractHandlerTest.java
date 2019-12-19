package com.bank.handler;

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
public class AbstractHandlerTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Mock
    private BuzzHandler mockedBuzzHandler;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldSetHandler_whenValidHandlerPassed() {
        AbstractHandler absCls = Mockito.mock(AbstractHandler.class, Mockito.CALLS_REAL_METHODS);
        AbstractHandler actual = absCls.setNext(mockedBuzzHandler);

        Assertions.assertThat(actual).isEqualTo(mockedBuzzHandler);
    }

    @Test
    public void shouldNotPrintInput_whenParameterDoesNotMatchCondition() {
        AbstractHandler absCls = Mockito.mock(AbstractHandler.class, Mockito.CALLS_REAL_METHODS);
        absCls.applyTo(Mockito.anyInt());
    }

    @Test
    public void shouldThrowNullPointerException_whenZeroPassed() {
        AbstractHandler absCls = Mockito.mock(AbstractHandler.class, Mockito.CALLS_REAL_METHODS);
        absCls.applyTo(0);
    }
}