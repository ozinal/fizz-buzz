package com.bank.utils;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class ConstantsTest {

    private Constants constants;

    @Before
    public void setUp() {
        constants = new Constants();
    }

    @Test
    public void testDefaultConstuction() {
        Assertions.assertThat(constants.THREE).isEqualTo(3);
        Assertions.assertThat(constants.FIVE).isEqualTo(5);

        Assertions.assertThat(constants.FIZZ_BUZZ).isEqualTo("FizzBuzz");
        Assertions.assertThat(constants.FIZZ).isEqualTo("Fizz");
        Assertions.assertThat(constants.BUZZ).isEqualTo("Buzz");
    }
}