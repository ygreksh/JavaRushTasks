package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;

class LoginCommand implements Command {


    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.class.getPackage().getName() + ".resources.verifiedCards");
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.class.getPackage().getName() + ".resources.login_en");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));

        do
        {
            ConsoleHelper.writeMessage(res.getString("specify.data"));
            String inputCard = ConsoleHelper.readString();

            ConsoleHelper.writeMessage("Введите ПИН:");
            String inputPIN = ConsoleHelper.readString();
            if (!inputCard.matches("^\\d{12}$") || !inputPIN.matches("^\\d{4}$"))
            {
                ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
            }
            else
            {
                if (validCreditCards.containsKey(inputCard) & inputPIN.equals(validCreditCards.getString(inputCard))) {
                    ConsoleHelper.writeMessage(res.getString("success.format"));
                    break;
                } else {
                    ConsoleHelper.writeMessage(res.getString("not.verified.format"));
                    ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                    continue;
                }
            }
        } while (true);
    }
}
