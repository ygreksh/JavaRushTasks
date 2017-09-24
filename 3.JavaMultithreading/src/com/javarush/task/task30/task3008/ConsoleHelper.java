package com.javarush.task.task30.task3008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static void writeMessage(String message){
        System.out.println(message);
    }
    public static String readString() throws IOException{
        String line=null;
        while (line==null) {
            try {
                line = bufferedReader.readLine();
            } catch (IOException e) {
                //e.printStackTrace();
                System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
                line = null;
            }
        }
        return line;
    }
    public static int readInt() throws IOException {
        String line = null;
        int number = 0;
        boolean readIntFlag = false;
        while (readIntFlag == false) {
            try {
                line = readString();
                number = Integer.parseInt(line);
                readIntFlag = true;
            } catch (NumberFormatException e) {
                //e.printStackTrace();
                System.out.println("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
                readIntFlag = false;
            }
        }
        return number;
    }
}
