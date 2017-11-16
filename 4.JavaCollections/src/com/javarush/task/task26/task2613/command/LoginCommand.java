package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

public class LoginCommand implements Command {
    private String cardNumber = "123456789012";
    private String cardPIN = "1234";
    @Override
    public void execute() throws InterruptOperationException {
        String inputCardNumber;
        String inputCardPIN;

        while (true){
            ConsoleHelper.writeMessage("Введите номер карты");
            inputCardNumber = ConsoleHelper.readString();
            if (inputCardNumber.toLowerCase().equals("exit")){
                throw  new InterruptOperationException();
            }
            if (inputCardNumber.length() != 12){
                ConsoleHelper.writeMessage("Направильный номер карты");
                continue;
            }
            ConsoleHelper.writeMessage("Введите PIN");
            inputCardPIN = ConsoleHelper.readString();
            if (inputCardPIN.toLowerCase().equals("exit")){
                throw  new InterruptOperationException();
            }
            if (inputCardNumber.length() != 12){
                ConsoleHelper.writeMessage("Направильный PIN");
                continue;
            }
            /*
            if (inputCardNumber.toLowerCase().equals("exit") || inputCardPIN.toLowerCase().equals("exit")){
                throw  new InterruptOperationException();
            }else
            if (inputCardNumber.equals(cardNumber) &&
                    inputCardPIN.equals(cardPIN)){
                ConsoleHelper.writeMessage("Dерификация прошла успешно");
                break;
            }else {
                ConsoleHelper.writeMessage("Направильный номер карты млм PIN");
                continue;
            }
            */

        }

        /*
        while (true) {
            ConsoleHelper.writeMessage("Введите номер карты");
            String readNumber = ConsoleHelper.readString();
            String readPin = ConsoleHelper.readString();
            if (readNumber.equals(cardNumber) && readPin.equals(cardPIN)) {
                ConsoleHelper.writeMessage(String.format(res.getString("success.format"),readNumber));
                break;
            }
            ConsoleHelper.writeMessage(res.getString("not.verified.format"));
            ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
            ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
        }
        */
    }
}
