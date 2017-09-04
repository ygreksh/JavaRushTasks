package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        char space = ' ';
        //String space = " ";
        //int data;
        int count=0;
        int all=fileInputStream.available();
        byte[] buffer = new byte[all];
        fileInputStream.read(buffer);
        for (byte b: buffer){
            if (b==space)count++;
        }
        double x = (double)count/(double)all*100;
        System.out.printf("%.2f",x);
        fileInputStream.close();
    }
}
