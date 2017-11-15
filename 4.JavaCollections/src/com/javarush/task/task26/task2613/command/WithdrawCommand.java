package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.Map;
import java.util.TreeMap;

class WithdrawCommand implements Command {
    @Override
    public void execute() throws InterruptOperationException {
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        do {
            ConsoleHelper.writeMessage("Enter amount.");
            int amount = 0;
            try {
                amount = Integer.parseInt(ConsoleHelper.readString());
                if (amount <= 0) throw new NumberFormatException();
            } catch (NumberFormatException e)
            {
                ConsoleHelper.writeMessage("Wrong input.");
                continue;
            }
            try
            {
                if (!currencyManipulator.isAmountAvailable(amount))
                {
                    throw new NotEnoughMoneyException();
                }
                TreeMap< Integer, Integer > treeCashMap = new TreeMap<>(currencyManipulator.withdrawAmount(amount));
                for (Map.Entry< Integer, Integer > entry : treeCashMap.descendingMap().entrySet())
                {
                    ConsoleHelper.writeMessage(String.format("\t%d - %d", entry.getKey(), entry.getValue()));
                }
                ConsoleHelper.writeMessage("Operation successfully completed.");
                break;
            }
            catch (NotEnoughMoneyException e)
            {
                ConsoleHelper.writeMessage("Not enough money.");
                continue;
            }
        } while (true);

    }
}
