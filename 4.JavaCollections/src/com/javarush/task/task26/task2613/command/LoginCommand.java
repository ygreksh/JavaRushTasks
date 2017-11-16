package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.Locale;
import java.util.ResourceBundle;

class LoginCommand implements Command {
    private final static String cardNumber = "123456789012";
    private final static String pincode = "1234";
    private boolean success = false;

    //private ResourceBundle validCreditCards = ResourceBundle.getBundle("com.javarush.test.level26.lesson15.big01.resources.verifiedCards", Locale.ENGLISH);
    private ResourceBundle validCreditCards = ResourceBundle.getBundle("com.javarush.task.task26.task2613.resources.verifiedCards");

    @Override
    public void execute() throws InterruptOperationException {
        /*
        while (true) {
            try {
                ConsoleHelper.writeMessage("Введите номер карты (12 цифр) и пин-код карты (4 цифры):");
                String numb = ConsoleHelper.readString();
                String pin = ConsoleHelper.readString();
                if (numb.length() != 12) throw new Exception();
                if (pin.length() != 4) throw new Exception();
                if (!numb.equals(cardNumber) && !pin.equals(pincode)) throw new Exception();
                else {ConsoleHelper.writeMessage("Верификация прошла успешно.");
                return;}
            } catch (Exception e) {
                ConsoleHelper.writeMessage("Данные невалидны. Повторите пожалуйста");
            }
        }
        */
        do
        {
            ConsoleHelper.writeMessage("Введите номер карты:");
            String inputCard = ConsoleHelper.readString();

            ConsoleHelper.writeMessage("Введите ПИН:");
            String inputPIN = ConsoleHelper.readString();
            if (!inputCard.matches("^\\d{12}$") || !inputPIN.matches("^\\d{4}$"))
            {
                ConsoleHelper.writeMessage("Ошибка ввода. Попробуйте еще раз.");
            }
            else
            {
                if (validCreditCards.containsKey(inputCard) & inputPIN.equals(validCreditCards.getString(inputCard))) {
                    ConsoleHelper.writeMessage("Верификация пройдена успешно!");
                    break;
                } else {
                    ConsoleHelper.writeMessage("Карта не найдена в базе!");
                    continue;
                }
            }
        } while (!success);
    }
}
