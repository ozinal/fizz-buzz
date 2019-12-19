package com.bank.utils;

import com.bank.helper.ConsolePrinter;
import com.bank.helper.impl.BlueConsolePrinter;
import com.bank.helper.impl.RedConsolePrinter;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ConsolePrinterUtilTest {

    @Test
    public void testDefaultConstructor() {
        ConsolePrinterUtil actual = new ConsolePrinterUtil();

        Assertions.assertThat(actual).isInstanceOf(ConsolePrinterUtil.class);
        Assertions.assertThat(actual).isNotNull();
    }

    @Test
    public void shouldReturnRedConsolePrinter_whenRedPrinterRequested() {
        ConsolePrinter actual = ConsolePrinterUtil.getUnderlyingRedConsolePrinter();

        Assertions.assertThat(actual).isInstanceOf(RedConsolePrinter.class);
        Assertions.assertThat(actual).isNotNull();
    }

    @Test
    public void shouldReturnBlueConsolePrinter_whenBluePrinterRequested() {
        ConsolePrinter actual = ConsolePrinterUtil.getUnderlyingBlueConsolePrinter();

        Assertions.assertThat(actual).isInstanceOf(BlueConsolePrinter.class);
        Assertions.assertThat(actual).isNotNull();
    }
}