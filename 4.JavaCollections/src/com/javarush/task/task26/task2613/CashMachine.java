package com.javarush.task.task26.task2613;

import java.io.IOException;
import java.util.Locale;

public class CashMachine {
    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.ENGLISH);
        Operation operation = Operation.DEPOSIT;
        String currCode = ConsoleHelper.askCurrencyCode();
        String[] dn = ConsoleHelper.getValidTwoDigits(currCode);
        int nominal = Integer.parseInt(dn[0]);
        int count = Integer.parseInt(dn[1]);
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currCode);
        manipulator.addAmount(nominal, count);

    }
}
