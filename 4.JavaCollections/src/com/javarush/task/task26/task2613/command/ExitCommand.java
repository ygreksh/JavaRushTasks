package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;


class ExitCommand implements Command {
    //private ResourceBundle res = ResourceBundle.getBundle(CashMachine.class.getPackage().toString() + "exit_en.properties");;
    private ResourceBundle res = ResourceBundle.getBundle("com.javarush.task.task26.task2613.resources.exit_en.properties");
    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("exit.question.y.n"));

        String s = null;
        s = ConsoleHelper.readString();
        if (s.equalsIgnoreCase("Y")) {
                ConsoleHelper.writeMessage("Bye");
            }

    }
}
