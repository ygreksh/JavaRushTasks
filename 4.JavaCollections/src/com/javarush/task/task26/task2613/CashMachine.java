package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.command.CommandExecutor;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.Locale;

public class CashMachine {
    public static void main(String[] args){
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
        /*
        try {
            CommandExecutor.execute(Operation.LOGIN);
        } catch (InterruptOperationException e) {
            try {
                CommandExecutor.execute(Operation.EXIT);
            } catch (InterruptOperationException ignored) {
            }
            //ConsoleHelper.printExitMessage();
        }
        try {
            Operation operation;
            do {
                operation = ConsoleHelper.askOperation();
                CommandExecutor.execute(operation);
            } while (operation != Operation.EXIT);
        } catch (InterruptOperationException e) {
            ConsoleHelper.writeMessage("Bay");
        }*/
        try
        {
            CommandExecutor.execute(Operation.LOGIN);
            Operation operation;

            do
            {
                ConsoleHelper.writeMessage("Введите 1,2,3, или 4");
                operation = ConsoleHelper.askOperation();

                CommandExecutor.execute(operation);
            }
            while (operation != Operation.EXIT);
        }
        catch (InterruptOperationException e) {

            try {
                CommandExecutor.execute(Operation.EXIT);
            } catch (InterruptOperationException ignored) {
            }
        }
    }
}
