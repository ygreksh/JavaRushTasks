package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {
        /*
        String fileName = args[0];
        int number = Integer.parseInt(args[1]);
        String text = args[2];
        RandomAccessFile file = new RandomAccessFile(fileName,"r");
        //long fileSize = Files.size(Paths.get(fileName));

        if (number > file.length()) file.seek(file.length());
        else file.seek(number);
        //file.seek(number);
        file.write(text.getBytes());
        file.close();
        */
        String fileName = args[0];
        int number = Integer.parseInt(args[1]);
        String text = args[2];
        int size = text.length();
        RandomAccessFile file = new RandomAccessFile(fileName,"rw");
        //int endOfFile = (int) file.length();
        file.seek(number);
        byte[] bytes = new byte[size];
        file.read(bytes, 0, size);
        String text2 = convertByteToString(bytes);
        file.seek(file.length());
        String answer;
        if (text2.equals(text)){
            answer = "true";
        } else {
            answer = "false";
        }
        file.write(answer.getBytes());
        file.close();

    }
    public static String convertByteToString(byte readBytes[]){
        //return String.valueOf(readBytes);
        return  new String(readBytes);
    }
}
