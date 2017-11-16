package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.IOException;

class ExitCommand implements Command {
    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage("Are you sure want to quit? (y,n):");

        String s = null;
        s = ConsoleHelper.readString();
        if (s.toUpperCase().equals("Y")) {
                ConsoleHelper.writeMessage("Bye");
            }

    }
}