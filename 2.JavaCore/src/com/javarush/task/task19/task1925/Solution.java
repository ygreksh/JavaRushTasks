package com.javarush.task.task19.task1925;

/* 
Длинные слова
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
                if (s.length()>6) newlines.add(s);
            }
        }
        String result = "";
        for (int i = 0; i < newlines.size(); i++) {
            if (i == newlines.size()-1)
                result = result + newlines.get(i);
            else
                result = result + newlines.get(i) + ",";
        }

        filewriter.write(result);
        filewriter.close();
    }
}
