package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;


class DepositCommand implements Command {
    //private ResourceBundle res = ResourceBundle.getBundle("com.javarush.task.task26.task2613.resources.verifiedCards" + "deposit_en.properties");
    private ResourceBundle res = ResourceBundle.getBundle("com.javarush.task.task26.task2613.resources.deposit_en.properties");
    @Override
    public void execute() throws InterruptOperationException{
        ConsoleHelper.writeMessage(res.getString("before"));
        String currencyCode = null;
        try {
            currencyCode = ConsoleHelper.askCurrencyCode();
            CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
            String[] s = ConsoleHelper.getValidTwoDigits(currencyCode);
            int nominal = Integer.parseInt(s[0]);
            int total = Integer.parseInt(s[1]);
            currencyManipulator.addAmount(nominal, total);
        } catch (NumberFormatException e) {
            ConsoleHelper.writeMessage("Error");
        }
    }
}
