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
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        try {
            line = bis.readLine();
        } catch (IOException ignored) {
            //e.printStackTrace();
            //line = reader.readLine();
        }
        return line;
    }
}
