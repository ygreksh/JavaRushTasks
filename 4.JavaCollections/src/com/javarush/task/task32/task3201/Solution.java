package com.javarush.task.task32.task3201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Paths;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) throws IOException {
        String fileName = args[0];
        int number = Integer.parseInt(args[1]);
        String text = args[2];
        RandomAccessFile file = new RandomAccessFile(fileName,"r");
        //long fileSize = Files.size(Paths.get(fileName));
        /*
        if (fileSize < number) {
            file.seek(fileSize);
        }else {
            file.seek(number);
        }*/
        if (number > file.length()) file.seek(file.length());
        else file.seek(number);
        //file.seek(number);
        file.write(text.getBytes());
        file.close();
    }
}
