package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();
        BufferedReader filereader = new BufferedReader(new FileReader(filename));
        String line;
        ArrayList<String> lines = new ArrayList<>();
        ArrayList<String> reverselines = new ArrayList<>();

        while ((line=filereader.readLine()) != null){
            lines.add(line);
        }
        filereader.close();
        //String reverse="";

        for (String l : lines){
            reverselines.add(new StringBuilder(l).reverse().toString());
        }

        for (String newstr : reverselines){
            System.out.println(newstr);
        }
    }
}
