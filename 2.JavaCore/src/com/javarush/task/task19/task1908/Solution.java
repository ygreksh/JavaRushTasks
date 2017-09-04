package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();
        String filename2 = reader.readLine();
        reader.close();
        BufferedReader fr = new BufferedReader(new FileReader(filename1));
        BufferedWriter fw = new BufferedWriter(new FileWriter(filename2));

        //ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<Integer> digits = new ArrayList<>();
        String line;
        while ((line=fr.readLine())!=null){
            //arrayList.add(line);
            String[] ss = line.split(" ");
            for (String s : ss){
                try {
                    digits.add(Integer.parseInt(s));
                } catch (NumberFormatException e) {}
            }
        }
        fr.close();
        for (Integer i : digits){
            fw.write(i.toString() + " ");
        }
        fw.close();
    }
}
