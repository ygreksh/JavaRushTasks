package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.ArrayList;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();
        //BufferedReader fr = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
        ByteArrayInputStream filereader = new ByteArrayInputStream(new FileInputSt);
        byte[] bytes = new byte[filereader.available()];
        filereader.read(bytes);
        String fullfile = String.valueOf(bytes);
        //System.out.println("Содержимое файла:\n" + fullfile);
        String[] words = fullfile.split(" ");
        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        ArrayList<String> wordlist = new ArrayList<>();
        StringBuilder strb = new StringBuilder();
        for (String word : words){
            wordlist.add(word);
        }
        char startchar=0;
        char endchar=0;
        ArrayList<String> newwordlist = new ArrayList<>();
        for (String word : wordlist){
            if (newwordlist.isEmpty()){
                newwordlist.add(word);
                endchar = word.toLowerCase().charAt(word.length() - 1);
                //System.out.println("Первое слово: " + word +". end is " + Character.toString(endchar));
                continue;
            }

            for (String w : wordlist) {
                startchar = w.toLowerCase().charAt(0);
                if (!newwordlist.contains(w) && startchar == endchar) {
                    newwordlist.add(w);
                    endchar = w.toLowerCase().charAt(w.length() - 1);
                    //System.out.println("Следующее слово: " + w + ". end is " + Character.toString(endchar));
                }
            }
        }
        for (String s : newwordlist){
            if (strb.toString().equals(""))strb.append(s);
            else strb.append(" ").append(s);
        }
        return strb;
    }
}
