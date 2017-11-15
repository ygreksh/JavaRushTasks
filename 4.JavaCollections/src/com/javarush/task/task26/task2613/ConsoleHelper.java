package com.javarush.task.task26.task2613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static final BufferedReader bis;

    static {
        bis = new BufferedReader(new InputStreamReader(System.in));
    }
    public static void writeMessage(String message){
        System.out.println(message);
    }
    public static String readString() throws IOException {
        String line = "";
        try {
            line = bis.readLine();
        } catch (IOException ignored) {
        }
        return line;
    }
    public static String askCurrencyCode() throws IOException {
        boolean flag = false;
        String currencyCode = "";
        while (!flag) {
            writeMessage("Введи код валюты (3 буквы):");
            currencyCode = readString();
            if (currencyCode.length() != 3) {
                writeMessage("Неправильный код!");
            }
            else {
                flag = true;
            }
        }
        return currencyCode.toUpperCase();
    }
    public static String[] getValidTwoDigits(String currencyCode) throws IOException {

        writeMessage("Введите номинал и количество банкнот (два числа через пробел)");

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
                writeMessage("Неправильно, посторите ввод:");
                continue;
            }
            break;
        }
        return array;
    }
    public static Operation askOperation(){
        while (true)
        {
            String line = null;
            try {
                line = readString();
            } catch (IOException e) {
                continue;
            }
            if (Integer.parseInt(line) > 0 && Integer.parseInt(line) < 5)
                return Operation.getAllowableOperationByOrdinal(Integer.parseInt(line));
            else
                writeMessage("Неправильно. Посторите ввод");
        }
    }
}
