package com.bank.utils;

import com.bank.helper.ConsolePrinter;
import com.bank.helper.impl.BlueConsolePrinter;
import com.bank.helper.impl.RedConsolePrinter;

/**
 * Utilities the initialisation of ConsolePrinter interface for both RedConsolePrinter and BlueConsolePrinter
 */
public class ConsolePrinterUtil {

    public static ConsolePrinter getUnderlyingRedConsolePrinter() {
        return new RedConsolePrinter();
    }

    public static ConsolePrinter getUnderlyingBlueConsolePrinter() {
        return new BlueConsolePrinter();
    }
}