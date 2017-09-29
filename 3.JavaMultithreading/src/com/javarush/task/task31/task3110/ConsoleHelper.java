package com.javarush.task.task31.task3110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    public static void writeMessage(String message){
        System.out.println(message);
    }
    public static String readString(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        try {
            line = reader.readLine();
            reader.close();
        } catch (IOException e) {
            System.out.println("Ошибка ввода строки");
        }
        return line;
    }
    public  static int readInt() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = 0;
        try {
            String line = reader.readLine();
            number = Integer.parseInt(line);
            reader.close();
        } catch (IOException e) {
            System.out.println("Ошибка ввода числа");
        }
        return number;
    }
}
