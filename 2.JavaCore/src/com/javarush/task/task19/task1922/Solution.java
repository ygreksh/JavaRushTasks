package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();
        BufferedReader filereader = new BufferedReader(new FileReader(filename));
        String line;
        int count=0;
        //int count1=0;
        //int count2=0;
        //int count3=0;
        ArrayList<String> lines = new ArrayList<>();
        while((line = filereader.readLine()) != null) {
            lines.add(line);
        }
        for (String s : lines)
        {
            count=0;
            String[] sss = s.split(" ");
            for (String st : sss){
                for (String w : words){
                    if (st.equals(w)) count++;
                }
            }

          /*  if ((count1 == 0 && count2 == 1 && count3 == 1) || (count1 == 1 && count2 == 0 && count3 == 1) || (count1 == 1 && count2 == 1 && count3 == 0)) {
                System.out.println(s);
            }*/
            if (count==2) System.out.println(s);
        }
        filereader.close();
    }
}
