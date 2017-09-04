package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(0,"ноль");
        map.put(1,"один");
        map.put(2,"два");
        map.put(3,"три");
        map.put(4,"четыре");
        map.put(5,"пять");
        map.put(6,"шесть");
        map.put(7,"семь");
        map.put(8,"восемь");
        map.put(9,"девять");
        map.put(10,"десять");
        map.put(11,"одиннадцать");
        map.put(12,"двенадцать");
    }

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();
        BufferedReader filereader = new BufferedReader(new FileReader(filename));
        String line;
        ArrayList<String> lines = new ArrayList<>();
        ArrayList<String> newlines = new ArrayList<>();

        while ((line=filereader.readLine()) != null){
            lines.add(line);
        }
        filereader.close();
        int number;
        String snumber;
        String newline = "";
        for (String l : lines){
            String[] words = l.split(" ");
            for (String s : words){
                try {
                    number = Integer.parseInt(s);
                    if (number>=0 && number<=12){ snumber = map.get(number);
                    newline = newline + " " + snumber;}
                    else newline = newline + " " + s;
                } catch (NumberFormatException e) {newline = newline + " " + s;}
            }
            newlines.add(newline);
        }
        for (String newstr : newlines){
            System.out.println(newstr);
        }
    }

}
