package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.command.CommandExecutor;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.IOException;
import java.util.Locale;

public class CashMachine {
    public static void main(String[] args) throws IOException, InterruptOperationException {
        Locale.setDefault(Locale.ENGLISH);
        /*
        Operation operation = Operation.DEPOSIT;
        String currCode = ConsoleHelper.askCurrencyCode();
        String[] dn = ConsoleHelper.getValidTwoDigits(currCode);
        int nominal = Integer.parseInt(dn[0]);
        int count = Integer.parseInt(dn[1]);
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currCode);
        manipulator.addAmount(nominal, count);
        ConsoleHelper.writeMessage("Всего денег этой валюты = " + String.valueOf(manipulator.getTotalAmount()));
        */
        Operation operation;
        do {
            operation = ConsoleHelper.askOperation();
            CommandExecutor.execute(operation);
        } while (operation != Operation.EXIT);
    }
}
