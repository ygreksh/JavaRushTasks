package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

public class ConsoleHelper {
    private static final BufferedReader bis;
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.class.getPackage().getName() + ".resources.common_en");

    static {
        bis = new BufferedReader(new InputStreamReader(System.in));
    }
    public static void writeMessage(String message){
        System.out.println(message);
    }
    public static String readString() throws InterruptOperationException{

        String line;
        while (true) {
            try {
                line = bis.readLine();
            } catch (IOException e) {
                continue;
            }
            if (line.equalsIgnoreCase("EXIT")) throw new InterruptOperationException();
            else return line;
        }
    }
    public static String askCurrencyCode() throws InterruptOperationException {
        boolean flag = false;
        String currencyCode = "";
        while (!flag) {
            writeMessage(res.getString("choose.currency.code"));
            currencyCode = readString();
            if (currencyCode.length() != 3) {
                writeMessage(res.getString("invalid.data"));
            }
            else {
                flag = true;
            }
        }
        return currencyCode.toUpperCase();
    }
    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {

        ConsoleHelper.writeMessage(String.format(res.getString("choose.denomination.and.count.format"), currencyCode));

        String[] array;
        while (true) {
            array = readString().split(" ");

            int nominal = 0;
            int count = 0;
            try {
                nominal = Integer.parseInt(array[0]);
                count = Integer.parseInt(array[1]);
            } catch (Exception e) {
                /*
                writeMessage("Неправильно, посторите ввод:");
                continue;
                */
            }
            if (nominal <= 0 || count <= 0) {
                writeMessage(res.getString("invalid.data"));
                continue;
            }
            break;
        }
        return array;
    }
    public static Operation askOperation() throws InterruptOperationException{
        while (true) {
            writeMessage(res.getString("choose.operation"));
            String operation = readString();
            if (operation.equalsIgnoreCase("help")) {
                writeMessage( res.getString("operation.INFO") + ": 1;\n" +
                        res.getString("operation.DEPOSIT") + ": 2;\n" +
                        res.getString("operation.WITHDRAW") + ": 3;\n" +
                        res.getString("operation.EXIT") + ": 4\n");
                operation = readString();
            }
            try {
                return Operation.getAllowableOperationByOrdinal(Integer.parseInt(operation));
            } catch (IllegalArgumentException ex) {
                writeMessage(res.getString("invalid.data"));
            }
        }
    }
    public static void printExitMessage() {
        ConsoleHelper.writeMessage(res.getString("the.end"));
    }
}
