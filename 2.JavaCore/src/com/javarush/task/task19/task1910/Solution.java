package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();
        String filename2 = reader.readLine();
        reader.close();
        BufferedReader fr = new BufferedReader(new FileReader(filename1));
        BufferedWriter fw = new BufferedWriter(new FileWriter(filename2));
        //FileReader fr = new FileReader(filename1);
        //FileWriter fw = new FileWriter(filename2);
        int data;
        String line;
        String fullline = "";
        String newline;
        while ((line=fr.readLine())!=null){
            fullline = fullline + line;
        }
        newline = fullline.replaceAll("\\p{Punct}", "");
        fw.write(newline);
        fr.close();
        fw.close();
    }
}