package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        String filename1 = args[0];
        String filename2 = args[1];

        BufferedReader filereader = new BufferedReader(new FileReader(filename1));
        BufferedWriter filewriter = new BufferedWriter(new FileWriter(filename2));
        String line;
        ArrayList<String> lines = new ArrayList<>();
        while ((line=filereader.readLine()) != null){
            lines.add(line);
        }
        ArrayList<String> newlines = new ArrayList<>();
        filereader.close();
        for (String l : lines){
            String[] ss = l.split(" ");
            for (String s : ss){
                if(s.contains("0")||s.contains("1")||s.contains("2")||s.contains("3")||s.contains("4")||s.contains("5")||s.contains("6")||s.contains("7")||s.contains("8")||s.contains("9")){newlines.add(s);}
            }
        }
        String newstr = "";
        for (String s : newlines) newstr = newstr + " " + s;
        filewriter.write(newstr);
        filewriter.close();
    }
}
