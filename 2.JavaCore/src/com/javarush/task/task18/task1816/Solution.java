package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException, FileNotFoundException{
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        String Eng = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int data;
        int count=0;
        //подсчет букв
        while(fileInputStream.available()>0){
            data = fileInputStream.read();
            if (Eng.indexOf(data)>=0){
                count++;
            }
        }
        System.out.println(count);
        fileInputStream.close();
    }
}
